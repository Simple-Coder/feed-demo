package com.example.feeddemo.controller;

import com.example.feeddemo.dto.TestValidateDTO;
import com.example.feeddemo.validate.ValidGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    //    @GetMapping("/a")
//    public Object a(@Validated TestValidateDTO testValidateDTO){
//        return JSON.toJSONString(testValidateDTO);
//    }

    @PostMapping(value = "/valid/add")
    //http://localhost:7879/feeddemo/validate/valid/add?name=javadaily&level=12&email=476938977@qq.com&sex=F
    public String add(HttpServletRequest request, HttpServletResponse response,
                      @Validated(value = ValidGroup.Crud.Create.class) TestValidateDTO validVO) {
        log.info("validEntity is {}", validVO);
        return "test3 valid success";
    }


    @PostMapping(value = "/valid/update")
    //http://localhost:7879/feeddemo/validate/valid/add?name=javadaily&level=12&email=476938977&sex=F
    public String update(@Validated(value = ValidGroup.Crud.Update.class) TestValidateDTO validVO) {
        log.info("validEntity is {}", validVO);
        return "test4 valid success";
    }
}
