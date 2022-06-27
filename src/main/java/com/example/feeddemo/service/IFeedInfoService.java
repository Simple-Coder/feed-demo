package com.example.feeddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.vo.HomeFeedReqInfo;
import com.example.feeddemo.vo.HomeFeedRspInfo;

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

    /**
     * 获取用户动态
     * @param reqInfo
     * @return
     */
    List<HomeFeedRspInfo> getUserHomeFeedListV1(HomeFeedReqInfo reqInfo);



    void test();
}
