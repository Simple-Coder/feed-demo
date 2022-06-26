package com.example.feeddemo.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feeddemo.entity.UserFeed;
import com.example.feeddemo.mapper.UserFeedMapper;
import com.example.feeddemo.service.IUserFeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by xiedong
 * Date: 2022/6/26
 */
@Service
@Slf4j
public class IUserFeedServiceImpl extends ServiceImpl<UserFeedMapper, UserFeed> implements IUserFeedService {
    @Autowired
    private UserFeedMapper userFeedMapper;

    @Override
    public void test() {
        for (int i = 0; i < 2; i++) {
            UserFeed userFeed = new UserFeed();
            userFeed.setUserId(Long.parseLong(RandomUtil.randomNumbers(5)));
            userFeed.setFeedUserId(Long.parseLong(RandomUtil.randomNumbers(5)));
            userFeed.setFeedId(Long.parseLong(RandomUtil.randomNumbers(5)));
            userFeed.setFeedStatus(1);
            userFeed.setCreateTime(new Date());
            userFeed.setUpdateTime(new Date());
            userFeedMapper.insert(userFeed);
        }
    }
}
