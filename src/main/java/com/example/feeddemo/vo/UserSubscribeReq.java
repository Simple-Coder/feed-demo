package com.example.feeddemo.vo;

import lombok.Data;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@Data
public class UserSubscribeReq {
    private Long lastId; //最后feedId
    private Long lastTime;//最后feed时间
    private Long userId;
    private int num=10;
}
