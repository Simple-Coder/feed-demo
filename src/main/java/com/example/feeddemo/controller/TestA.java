package com.example.feeddemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.feeddemo.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/7/6
 */
@RestController
@RequestMapping("feed/api/v2")
public class TestA {
    @GetMapping("/a")
    public String a(@RequestParam("callback") String callback){
        List<Integer> as=new ArrayList<>();

        as.add(1);
        as.add(13);
        as.add(2);
//        return JSON.toJSONString(R.ok(as));
        return callback+"("+JSON.toJSONString(R.ok(as))+")";
    }
}
