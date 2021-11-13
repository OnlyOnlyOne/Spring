package com.imooc.spring.ioc.service;

//import com.imooc.spring.ioc.dao.IUserDao;
import com.imooc.spring.ioc.dao.IUserDao;
import com.imooc.spring.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
//@Scope("prototype")//设置单例/多例,XML中 bean scope完全相同
public class UserService {
    //不再执行set方法

    private IUserDao udao;
    public IUserDao getUdao() {
        return udao;
    }


    //如果装配注解放在set方法上,则自动按类型/名称对set方法参数进行注入
    @Autowired
    public void setUdao(UserDao udao) {
        System.out.println("setUdao:" + udao);
        this.udao = udao;
    }


    public UserService(){
        System.out.println("正在创建UserService:" + this);
    }




}
