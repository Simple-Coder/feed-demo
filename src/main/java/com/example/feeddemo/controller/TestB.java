package com.example.feeddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiedong
 * Date: 2022/7/6
 */
@RestController
@RequestMapping("feed/api/v2")
public class TestB {

    @GetMapping("/b")
    public Object b(){
        return "ok b";
    }
}
