package com.example.feeddemo.utils;

import cn.hutool.core.date.DatePattern;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Created by xiedong
 * Date: 2022/6/27
 */
@Slf4j
@UtilityClass
public class DateUtil extends cn.hutool.core.date.DateUtil {
    private static final long second = 1;
    private static final long ONE_MINUTE = 60 * second;
    private static final long ONE_HOUR = 60 * ONE_MINUTE;
    private static final long ONE_DAY = 24 * ONE_HOUR;
    private static final long ONE_MONTH = 30 * ONE_DAY;


    /**
     * 时间戳转换
     * 转换规则：
     * <1分钟： 刚刚
     * >=1分钟，<1小时： x分钟前
     * >=1小时，<24小时： x小时前
     * >=24小时，<30天： x天前
     * >=30天： 年-月-日
     */
    public String convertTimeToTip(long timestamp) {
        String tip = "";
        try {
            long now = System.currentTimeMillis();
            long diff = (now - timestamp) / 1000;
            if (diff < ONE_MINUTE) {
                tip = "刚刚";
            } else if (diff < ONE_HOUR) {
                tip = diff / ONE_MINUTE + "分钟前";
            } else if (diff < ONE_DAY) {
                tip = diff / ONE_HOUR + "小时前";
            } else if (diff < ONE_MONTH) {
                tip = diff / ONE_DAY + "天前";
            } else {
                tip = DateFormatUtils.format(timestamp, DatePattern.NORM_DATE_PATTERN);
            }
        } catch (Exception exception) {
            log.error("convertTimeToTip failed, time:" + timestamp, exception);
        }
        return tip;
    }
}
