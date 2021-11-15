package com.imooc.spring.aop;

import com.imooc.spring.aop.service.UserService;
import com.imooc.spring.aop.service.UserServiceImpl;
import com.imooc.spring.aop.service.UserServiceProxy;

public class Applicaition {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
        //用户不再面向UserServiceImpl，而是面向UserServiceProxy
        UserService userService = new UserServiceProxy(new UserServiceImpl());
        userService.createUser();
    }
}
