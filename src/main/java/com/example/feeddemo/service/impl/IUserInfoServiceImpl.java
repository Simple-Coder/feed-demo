package com.example.feeddemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feeddemo.entity.UserInfo;
import com.example.feeddemo.mapper.UserInfoMapper;
import com.example.feeddemo.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@Service
@Slf4j
public class IUserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
}
