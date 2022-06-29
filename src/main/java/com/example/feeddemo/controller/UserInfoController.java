package com.example.feeddemo.controller;

import com.example.feeddemo.common.R;
import com.example.feeddemo.entity.UserInfo;
import com.example.feeddemo.service.IUserInfoService;
import com.example.feeddemo.vo.UserInfoAddReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@RestController
@Slf4j
@RequestMapping("/userinfos")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;


    @PutMapping("/add")
    public R addUser(@RequestBody UserInfoAddReq req) {
//        int a = 1/0;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(req.getUserId());
        userInfo.setNickname(req.getNickname());
        userInfo.setUserType(req.getUserType());
        return R.ok(userInfoService.save(userInfo));
    }
}
