package com.example.feeddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.feeddemo.entity.UserFeed;
import com.example.feeddemo.vo.UserSubscribeReq;
import com.example.feeddemo.vo.UserSubscribeRsp;

import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/26
 */
public interface IUserFeedService extends IService<UserFeed> {
    void test();

    /**
     * 获取feed流信息
     *
     * @param subscribeReq
     * @return
     */
    List<UserSubscribeRsp> getUserSubscribe(UserSubscribeReq subscribeReq);
}
