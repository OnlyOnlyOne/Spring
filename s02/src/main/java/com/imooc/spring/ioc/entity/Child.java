package com.imooc.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Child {
    private String name;
    private Apple apple;

    public void eat() {
        System.out.println(name + "吃到了" + apple.getOrigin() + "种植的" + apple.getTitle());

    }
}
