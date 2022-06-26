package com.example.feeddemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiedong
 * Date: 2022/6/26
 */
@Data
@TableName("user_feed")
public class UserFeed implements Serializable {
    private Long id;
    private Long userId;
    private Long feedId;
    private Long feedUserId;
    //    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private int feedStatus;
}
