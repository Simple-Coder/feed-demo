package com.example.feeddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.feeddemo.entity.FeedInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiedong
 * @since 2022-06-19
 */
@Mapper
public interface FeedInfoMapper extends BaseMapper<FeedInfo> {
    List<FeedInfo> getUserHomeV1(@Param("userId") Long userId,
                                 @Param("lastTime") String lastTime,
                                 @Param("num") int num);
}
