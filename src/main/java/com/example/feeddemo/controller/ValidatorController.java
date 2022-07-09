package com.example.feeddemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.feeddemo.dto.TestValidateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiedong
 * Date: 2022/7/9
 * 参数校验测试
 */
@RestController
@Slf4j
@RequestMapping("/validate")
@Validated
public class ValidatorController {
    @GetMapping("/a")
    public Object a(@Validated TestValidateDTO testValidateDTO){
        return JSON.toJSONString(testValidateDTO);
    }
}
