package com.example.feeddemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiedong
 * Date: 2022/6/27
 */
@Data
public class UserFollowInfos implements Serializable {
    private Long id;
    private Long userId;
    private int bigVStatus;
    private Long followUserId;
    private Date createTime;
    private Date updateTime;
}
