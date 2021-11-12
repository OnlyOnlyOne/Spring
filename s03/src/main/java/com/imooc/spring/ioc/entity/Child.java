package com.imooc.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Child {
    private String name;
    private Apple apple;

    public Child(String name, Apple apple) {
        System.out.println("调用了构造方法" + apple);
        this.name = name;
        this.apple = apple;
    }

    public void eat() {
        System.out.println(name + "吃到了" + apple.getOrigin() + "种植的" + apple.getTitle());

    }
}
