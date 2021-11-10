package com.imooc.spring.ioc;

import com.imooc.spring.ioc.entity.Apple;
import com.imooc.spring.ioc.entity.Child;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Context;

public class SpringApplication {
    public static void main(String[] args) {
        //启动IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Apple sweetApple = context.getBean("sweetApple", Apple.class);
        System.out.println(sweetApple.getTitle());
        Child lily = context.getBean("lily", Child.class);
        lily.eat();
        Child andy = context.getBean("andy", Child.class);
        Child luna = context.getBean("luna", Child.class);
        andy.eat();
        luna.eat();
    }
}
