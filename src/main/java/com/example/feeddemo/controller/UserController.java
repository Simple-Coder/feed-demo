package com.example.feeddemo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.feeddemo.entity.User;
import com.example.feeddemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiedong
 * @since 2022-06-19
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ApiOperation("查询列表")
    public Page<User> list(@ApiParam("当前页") @RequestParam(defaultValue = "1") Integer page,
                           @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer size) {
        return this.userService.page(new Page<>(page, size),
                Wrappers.lambdaQuery(User.class).orderByAsc(User::getId));
    }

    @GetMapping("/detail")
    @ApiOperation("查询详情")
    public User detail(@ApiParam("主键") @RequestParam("id") Long id) {
        return this.userService.getById(id);
    }


    @PostMapping("/edit")
    @ApiOperation("保存或修改")
    public User edit(@RequestBody User user) {
        this.userService.saveOrUpdate(user);
        return user;
    }


    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public boolean delete(@PathVariable("id") Long id) {
        return this.userService.removeById(id);
    }
}


