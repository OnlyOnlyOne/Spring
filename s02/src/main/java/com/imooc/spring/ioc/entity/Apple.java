package com.imooc.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
public class Apple {
    private String title;
    private String color;
    private String origin;

    public Apple() {
        System.out.println("Apple对象已创建"+this);
    }

    public Apple(String title, String color, String origin) {
        System.out.println("通过带参构造方法创建对象，" + this);
        this.title = title;
        this.color = color;
        this.origin = origin;
    }
}
