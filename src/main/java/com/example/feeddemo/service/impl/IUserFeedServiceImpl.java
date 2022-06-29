package com.example.feeddemo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.entity.UserFeed;
import com.example.feeddemo.mapper.UserFeedMapper;
import com.example.feeddemo.service.IFeedInfoService;
import com.example.feeddemo.service.IUserFeedService;
import com.example.feeddemo.vo.UserSubscribeReq;
import com.example.feeddemo.vo.UserSubscribeRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/26
 */
@Service
@Slf4j
public class IUserFeedServiceImpl extends ServiceImpl<UserFeedMapper, UserFeed> implements IUserFeedService {
    @Autowired
    private UserFeedMapper userFeedMapper;
    @Autowired
    private IFeedInfoService feedInfoService;

    @Override
    public UserSubscribeRsp getUserSubscribe(UserSubscribeReq subscribeReq) {
        //pull 大V动态
        UserSubscribeRsp rsp = new UserSubscribeRsp();
        QueryWrapper<UserFeed> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        queryWrapper.eq("user_id", subscribeReq.getUserId());
        //push的普通用户
        Page<UserFeed> userFeedPages = userFeedMapper.selectPage(new Page<>(0, subscribeReq.getNum()), queryWrapper);
        List<FeedInfo> feedInfos = new ArrayList<>();
        for (UserFeed record : userFeedPages.getRecords()) {
            FeedInfo feedInfo = feedInfoService.getByUserIdAndId(record.getFeedId(), record.getFeedUserId());
            feedInfos.add(feedInfo);
        }
        if (CollUtil.isNotEmpty(feedInfos)) {
            rsp.setFeedInfos(feedInfos);
            rsp.setLastId(feedInfos.get(feedInfos.size() - 1).getId());
            rsp.setLastTime(feedInfos.get(feedInfos.size() - 1).getCreateTime().getTime());
        } else {
            rsp.setLastId(0L);
            rsp.setLastTime(0L);
        }
        return rsp;
    }

    @Override
    public void test() {
        for (int i = 0; i < 2; i++) {
            UserFeed userFeed = new UserFeed();
//            userFeed.setUserId(Long.parseLong(RandomUtil.randomNumbers(5)));
            userFeed.setUserId(1003L);
            userFeed.setFeedUserId(Long.parseLong(RandomUtil.randomNumbers(5)));
            userFeed.setFeedId(Long.parseLong(RandomUtil.randomNumbers(5)));
            userFeed.setFeedStatus(1);
            userFeed.setCreateTime(new Date());
            userFeed.setUpdateTime(new Date());
            userFeedMapper.insert(userFeed);
        }
    }
}
