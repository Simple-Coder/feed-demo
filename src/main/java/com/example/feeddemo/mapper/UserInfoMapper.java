package com.example.feeddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.feeddemo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
