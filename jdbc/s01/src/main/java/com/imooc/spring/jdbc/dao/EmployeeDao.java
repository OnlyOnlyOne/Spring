package com.imooc.spring.jdbc.dao;

import com.imooc.spring.jdbc.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findByDnames(String dname) {
        String sql = "select * from employee where dname = ?";
        List<Employee> list = jdbcTemplate.query(sql,new Object[]{"研发部"}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }

    public Employee findById(Integer eno) {
        String sql = "select * from employee where eno = ?";
        Employee employee = jdbcTemplate.queryForObject(sql,new Object[]{eno},new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
    }

    public List<Map<String, Object>> findMapByDname(String dname) {
        String sql = "select eno as empno , salary as s from employee where dname = ?";
        //将返回结果作为Map进行封装
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql, new Object[]{dname});
        return listMap;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void insert(Employee employee) {
        String sql = "insert into employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{
                employee.getEno(),employee.getEname(),employee.getSalary(),employee.getDname()
                ,employee.getHiredate()
        });

    }

    public void ()

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
