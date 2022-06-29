package com.example.feeddemo.vo;

import lombok.Data;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@Data
public class UserInfoAddReq {
    private Long userId;
    private String nickname;
    private int userType; //0-普通用户、1-大v
}
