package com.example.feeddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.feeddemo.entity.FeedInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiedong
 * @since 2022-06-19
 */
public interface IFeedInfoService extends IService<FeedInfo> {

    List<FeedInfo> getAllByUserId(Long userId);

    void test();
}
