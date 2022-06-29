package com.example.feeddemo.aspect;

import com.example.feeddemo.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by xiedong
 * Date: 2022/6/29
 */
@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(value = {Exception.class})
    public R defaultReturn(Exception e) {
        log.error("系统处理异常", e);
        return R.failed("系统异常:" + e.getMessage());
    }
}
