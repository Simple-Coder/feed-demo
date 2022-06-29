package com.example.feeddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.feeddemo.entity.UserFollowInfos;

import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/27
 */
public interface IUserFollowerInfosService extends IService<UserFollowInfos> {
    /**
     * 获取粉丝userId
     *
     * @param userId
     * @return
     */
    List<UserFollowInfos> getFansUserId(Long userId);
}
