package com.example.feeddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.feeddemo.entity.UserInfo;

/**
 * Created by xiedong
 * Date: 2022/6/29
 * 用户信息服务类
 */
public interface IUserInfoService extends IService<UserInfo> {

    UserInfo getUserInfoByUserId(Long userId);
}
