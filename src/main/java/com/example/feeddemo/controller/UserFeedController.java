package com.example.feeddemo.controller;

import com.example.feeddemo.common.R;
import com.example.feeddemo.service.IUserFeedService;
import com.example.feeddemo.vo.UserSubscribeReq;
import com.example.feeddemo.vo.UserSubscribeRsp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/26
 */
@RestController
@Slf4j
@RequestMapping("/userFeed")
@AllArgsConstructor
public class UserFeedController {
    private final IUserFeedService userFeedService;

    @GetMapping("/testInsert")
    public void testInsert() {
        this.userFeedService.test();
    }

    @GetMapping("/subscribe")
    public R<List<UserSubscribeRsp>> userSubscribe(UserSubscribeReq subscribeReq) {
        return R.ok(userFeedService.getUserSubscribe(subscribeReq));
    }
}
