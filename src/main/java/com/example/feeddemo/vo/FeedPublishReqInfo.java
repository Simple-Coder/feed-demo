package com.example.feeddemo.vo;

import lombok.Data;

/**
 * Created by xiedong
 * Date: 2022/6/27
 * 发表动态请求对象
 */
@Data
public class FeedPublishReqInfo {
    private Long userId;
    private String content;
}
