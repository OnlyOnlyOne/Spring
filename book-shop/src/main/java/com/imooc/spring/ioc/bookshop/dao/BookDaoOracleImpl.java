package com.imooc.spring.ioc.bookshop.dao;

public class BookDaoOracleImpl implements BookDao {
    @Override
    public void insert() {
        System.out.println("向Oracle Book中插入一条数据");
    }
}
