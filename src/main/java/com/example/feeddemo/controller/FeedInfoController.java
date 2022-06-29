package com.example.feeddemo.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.feeddemo.common.R;
import com.example.feeddemo.constants.CommonConstants;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.entity.UserFeed;
import com.example.feeddemo.entity.UserFollowInfos;
import com.example.feeddemo.entity.UserInfo;
import com.example.feeddemo.service.IFeedInfoService;
import com.example.feeddemo.service.IUserFeedService;
import com.example.feeddemo.service.IUserFollowerInfosService;
import com.example.feeddemo.service.IUserInfoService;
import com.example.feeddemo.vo.FeedPublishReqInfo;
import com.example.feeddemo.vo.HomeFeedReqInfo;
import com.example.feeddemo.vo.HomeFeedRspInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiedong
 * @since 2022-06-19
 */
@RestController
@RequestMapping("/feed/v1")
@Slf4j
public class FeedInfoController {
    @Autowired
    private IFeedInfoService feedInfoService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IUserFollowerInfosService userFollowerInfosService;
    @Autowired
    private IUserFeedService userFeedService;


    @GetMapping("/testInsert")
    public R<Object> testInsert() {
        this.feedInfoService.test();
        return R.ok();
    }

    /**
     * 查看个人主页
     *
     * @param reqInfo
     * @return
     */
    @GetMapping("/userHome")
    public R<List<HomeFeedRspInfo>> getUserHomeV1(HomeFeedReqInfo reqInfo) {
        try {
            return R.ok(feedInfoService.getUserHomeFeedListV1(reqInfo));
        } catch (Exception e) {
            log.error("userHome exception", e);
        }
        return R.failed();
    }

    @PutMapping("/publish")
    public R publishFeed(@RequestBody FeedPublishReqInfo reqInfo) {
        try {
//            return R.ok(feedInfoService.publishFeed(reqInfo));
            Long feedId = feedInfoService.publishFeed(reqInfo);
            //普通用户：发表动态并且写扩散
            UserInfo userInfoByUserId = userInfoService.getUserInfoByUserId(reqInfo.getUserId());
            if (userInfoByUserId.getUserType() == CommonConstants.COMMON_USER) {
                List<UserFollowInfos> fansUserIds = userFollowerInfosService.getFansUserId(userInfoByUserId.getUserId());
                if (CollUtil.isNotEmpty(fansUserIds)) {
                    for (UserFollowInfos fansUserInfos : fansUserIds) {
                        UserFeed userFeed = new UserFeed();
                        userFeed.setUserId(fansUserInfos.getUserId());
                        userFeed.setFeedUserId(reqInfo.getUserId());
                        userFeed.setFeedStatus(CommonConstants.FEED_STATUS_NORMAL);
                        userFeed.setFeedId(feedId);
                        userFeedService.save(userFeed);
                    }
                } else {
                    log.error("当前用户userId:{}没有粉丝", userInfoByUserId.getUserId());
                }
            } else {
                log.info("当前用户userId:{}是大v", userInfoByUserId.getUserId());
            }
        } catch (Exception e) {
            log.error("publish feed error", e);
        }
        return R.failed();
    }


    @GetMapping("/list")
    public R list(@RequestParam(defaultValue = "1") Integer page,
                  @RequestParam(defaultValue = "10") Integer size) {
        return R.ok(this.feedInfoService.page(new Page<>(page, size),
                Wrappers.lambdaQuery(FeedInfo.class).orderByAsc(FeedInfo::getId)));
    }

    @GetMapping("/infos/{userId}")
    public R detail(@PathVariable("userId") Long userId) {
        return R.ok(this.feedInfoService.getAllByUserId(userId));
    }


    @PostMapping("/edit")
    public FeedInfo edit(@RequestBody FeedInfo feedInfo) {
        this.feedInfoService.saveOrUpdate(feedInfo);
        return feedInfo;
    }


    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return this.feedInfoService.removeById(id);
    }
}


