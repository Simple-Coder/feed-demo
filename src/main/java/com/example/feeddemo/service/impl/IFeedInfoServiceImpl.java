package com.example.feeddemo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feeddemo.constants.CommonConstants;
import com.example.feeddemo.entity.FeedInfo;
import com.example.feeddemo.mapper.FeedInfoMapper;
import com.example.feeddemo.service.IFeedInfoService;
import com.example.feeddemo.utils.DateUtil;
import com.example.feeddemo.vo.FeedPublishReqInfo;
import com.example.feeddemo.vo.HomeFeedReqInfo;
import com.example.feeddemo.vo.HomeFeedRspInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<HomeFeedRspInfo> getUserHomeFeedListV1(HomeFeedReqInfo reqInfo) {
        log.info("userHome v1 userId:{},lastId:{},lastTime:{}", reqInfo.getUserId(), reqInfo.getLastId(), reqInfo.getLastTime());
        if (Objects.isNull(reqInfo.getLastTime()) || reqInfo.getLastTime() == 0) {
            reqInfo.setLastTime(DateUtil.current());
        }
        Date createTimeDate = new Date(reqInfo.getLastTime());
        String lastDateStr = DateUtil.format(createTimeDate, DatePattern.NORM_DATETIME_FORMAT);
        List<FeedInfo> userHomeV1 = feedInfoMapper.getUserHomeV1(reqInfo.getUserId(), lastDateStr, reqInfo.getNum());
        if (CollUtil.isNotEmpty(userHomeV1)) {
            List<HomeFeedRspInfo> rspInfos = new ArrayList<>();
            for (FeedInfo feedInfo : userHomeV1) {
                HomeFeedRspInfo rspInfo = new HomeFeedRspInfo();
                rspInfo.setUserId(feedInfo.getUserId());
                rspInfo.setContent(feedInfo.getFeedContent());
                rspInfo.setTitile(DateUtil.convertTimeToTip(feedInfo.getCreateTime().getTime()) + "发表了动态");
                rspInfos.add(rspInfo);
            }
            return rspInfos;
        }
        return Collections.emptyList();
    }


    @Override
    public Long publishFeed(FeedPublishReqInfo reqInfo) {
        FeedInfo feedInfo = new FeedInfo();
        feedInfo.setFeedStatus(CommonConstants.FEED_STATUS_NORMAL);
        feedInfo.setUserId(reqInfo.getUserId());
        feedInfo.setFeedContent(reqInfo.getContent());
        boolean saveFlag = this.save(feedInfo);
        return saveFlag ? feedInfo.getId() : 0L;
    }


    @Override
    public List<FeedInfo> getAllByUserId(Long userId) {
        QueryWrapper<FeedInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return feedInfoMapper.selectList(wrapper);
    }

    @Override
    public void test() {
        for (int i = 0; i < 2; i++) {
            FeedInfo feedInfo = new FeedInfo();
            feedInfo.setFeedContent("feedContent" + i);
            feedInfo.setUserId(Long.parseLong(RandomUtil.randomNumbers(5)));
            feedInfo.setFeedStatus(1);
            feedInfo.setCreateTime(new Date());
            feedInfo.setUpdateTime(new Date());
            feedInfoMapper.insert(feedInfo);
        }
    }
}
