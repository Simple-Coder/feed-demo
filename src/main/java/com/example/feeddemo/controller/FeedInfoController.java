package com.example.feeddemo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.feeddemo.common.R;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.service.IFeedInfoService;
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
            //普通用户：发表动态并且写扩散

            feedInfoService.publishFeed(reqInfo);
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


