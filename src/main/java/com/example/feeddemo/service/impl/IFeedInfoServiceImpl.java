package com.example.feeddemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.mapper.FeedInfoMapper;
import com.example.feeddemo.service.IFeedInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiedong
 * @since 2022-06-19
 */
@Service
@Slf4j
public class IFeedInfoServiceImpl extends ServiceImpl<FeedInfoMapper, FeedInfo> implements IFeedInfoService {
    @Autowired
    private FeedInfoMapper feedInfoMapper;

    @Override
    public List<FeedInfo> getAllByUserId(Long userId) {
        QueryWrapper<FeedInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return feedInfoMapper.selectList(wrapper);
    }
}
