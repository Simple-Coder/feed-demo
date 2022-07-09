package com.example.feeddemo.dto;

import com.example.feeddemo.annotation.EnumString;
import lombok.Data;


/**
 * Created by xiedong
 * Date: 2022/7/9
 */
@Data
public class TestValidateDTO {
    private String id;

    @EnumString(value = {"F","M"}, message="sex只允许为F或M")
    private String sex;

    @EnumString(value = {"F","M"}, message="1性别只允许为F或M")
    private String sex1;


//    @Length(min = 6,max = 12,message = "appId长度必须位于6到12之间")
//    private String appId;
//
//    @NotBlank(message = "名字为必填项")
//    private String name;
//
//    private String sex;
//
//    @NotEmpty(message = "级别不能为空")
//    private String level;
}
