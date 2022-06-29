package com.example.feeddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.feeddemo.entity.UserFeed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/26
 */
@Mapper
public interface UserFeedMapper extends BaseMapper<UserFeed> {
    List<UserFeed> getUserFeedByUserIdV1(@Param("userId") Long userId,
                                         @Param("num") int num,
                                         @Param("userFeedId") Long userFeedId);
}
