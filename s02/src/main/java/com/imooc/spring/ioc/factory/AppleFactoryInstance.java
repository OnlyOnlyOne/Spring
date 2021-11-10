package com.imooc.spring.ioc.factory;

import com.imooc.spring.ioc.entity.Apple;

/*
* 工厂实例方法创建对象是指IOC容器对工厂类进行实例化并调用对应的实例方法创建
* 对象的过程
* */
public class AppleFactoryInstance {
    public Apple createSwApple() {
        Apple apple = new Apple();
        apple.setTitle("红富士");
        apple.setOrigin("欧洲");
        apple.setColor("红色");
        System.out.println("利用工厂实例方法创建对象");
        return apple;
    }


}
