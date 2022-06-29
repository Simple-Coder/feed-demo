package com.example.feeddemo.vo;

import com.example.feeddemo.entity.FeedInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@Data
public class UserSubscribeRsp {
    private Long lastId;
    private Long lastTime;
    List<FeedInfo> feedInfos;
}
