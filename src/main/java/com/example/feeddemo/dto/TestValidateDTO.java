package com.example.feeddemo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by xiedong
 * Date: 2022/7/9
 */
@Data
public class TestValidateDTO {
    private String id;

    @Length(min = 6,max = 12,message = "appId长度必须位于6到12之间")
    private String appId;

    @NotBlank(message = "名字为必填项")
    private String name;

    private String sex;

    @NotEmpty(message = "级别不能为空")
    private String level;
}
