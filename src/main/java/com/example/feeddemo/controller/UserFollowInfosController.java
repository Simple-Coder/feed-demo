package com.example.feeddemo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.feeddemo.common.R;
import com.example.feeddemo.entity.UserFollowInfos;
import com.example.feeddemo.service.IUserFollowerInfosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiedong
 * Date: 2022/6/27
 */
@RestController
@RequestMapping("/userFollowInfos")
@Slf4j
public class UserFollowInfosController {
    @Autowired
    private IUserFollowerInfosService userFollowerInfosService;


    @GetMapping("/list")
    public R list(@RequestParam(defaultValue = "1") Integer page,
                  @RequestParam(defaultValue = "10") Integer size) {
        return R.ok(this.userFollowerInfosService.page(new Page<>(page, size),
                Wrappers.lambdaQuery(UserFollowInfos.class).orderByAsc(UserFollowInfos::getId)));
    }
}
