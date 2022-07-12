package com.example.feeddemo.dto;

import com.example.feeddemo.validate.ValidGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


/**
 * Created by xiedong
 * Date: 2022/7/9
 */
@Data
public class TestValidateDTO {
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "ID不能为空")
    private String id;

    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "应用ID不能为空")
    private String appId;

    @NotBlank(groups = ValidGroup.Crud.Create.class, message = "名字为必填项")
    private String name;

    @Email(message = "请填写正确的邮箱地址")
    private String email;

    private int test1=-2;

//    private String id;

//    @EnumString(value = {"F","M"}, message="sex只允许为F或M")
//    private String sex;
//
//    @EnumString(value = {"F","M"}, message="1性别只允许为F或M")
//    private String sex1;


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
