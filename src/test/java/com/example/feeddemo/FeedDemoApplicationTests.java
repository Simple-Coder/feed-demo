package com.example.feeddemo;

import cn.hutool.core.util.RandomUtil;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.mapper.FeedInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class FeedDemoApplicationTests {
    @Autowired
    private FeedInfoMapper feedInfoMapper;
    @Test
    void contextLoads() {

    }

    @Test
    public void t1(){
        for (int i = 0; i < 2; i++) {
            FeedInfo feedInfo = new FeedInfo();
            feedInfo.setFeedContent("feedContent"+i);
            feedInfo.setUserId(Long.parseLong(RandomUtil.randomNumbers(5)));
            feedInfo.setFeedStatus(1);
            feedInfo.setCreateTime(new Date());
            feedInfo.setUpdateTime(new Date());
            feedInfoMapper.insert(feedInfo);
        }
    }

}
