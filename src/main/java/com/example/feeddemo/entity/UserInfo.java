package com.example.feeddemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@Data
@TableName("user_infos")
public class UserInfo extends BaseEntity implements Serializable {
    private Long id;
    private Long userId;
    private int userType;
    private String nickname;
}
