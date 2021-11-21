package com.imooc.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restful")
public class RestfulController {
    @GetMapping("/request")
    @ResponseBody
    public String doGetRequest() {
        /*双引号中如果包括双引号，要使用转义字符\*/
        return "{\"message\":\"返回查询结果\"}";
    }

    @PostMapping("/request")
    @ResponseBody
    public String doPostMapping() {
        return "{\"message\":\"数据新建成功\"}";
    }

    @PutMapping("/request")
    @ResponseBody
    public String doPutMapping() {
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    @ResponseBody
    public String doDeleteMapping() {
        return "{\"message\":\"数据删除成功\"}";
    }
}
