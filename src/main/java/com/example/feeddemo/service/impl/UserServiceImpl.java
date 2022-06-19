package com.example.feeddemo.service.impl;

import com.example.feeddemo.entity.User;
import com.example.feeddemo.mapper.UserMapper;
import com.example.feeddemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiedong
 * @since 2022-06-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
