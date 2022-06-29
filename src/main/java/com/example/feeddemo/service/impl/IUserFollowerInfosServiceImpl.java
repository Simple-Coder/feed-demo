package com.example.feeddemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feeddemo.entity.UserFollowInfos;
import com.example.feeddemo.mapper.UserFollowInfosMapper;
import com.example.feeddemo.service.IUserFollowerInfosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiedong
 * Date: 2022/6/27
 */
@Service
@Slf4j
public class IUserFollowerInfosServiceImpl extends ServiceImpl<UserFollowInfosMapper, UserFollowInfos> implements IUserFollowerInfosService {
    @Autowired
    private UserFollowInfosMapper userFollowInfosMapper;

    @Override
    public List<UserFollowInfos> getFansUserId(Long userId) {
        QueryWrapper<UserFollowInfos> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("follow_user_id", userId);
        return userFollowInfosMapper.selectList(queryWrapper);
    }
}
