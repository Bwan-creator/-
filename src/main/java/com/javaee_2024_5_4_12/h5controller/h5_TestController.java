package com.javaee_2024_5_4_12.h5controller;

import com.javaee_2024_5_4_12.entity.StuInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class h5_TestController {
    @RequestMapping("test_string")
    public String testString(){
        return "this is my first test string";
    }
    @RequestMapping("test_one_param")
    public String testOneParam(HttpServletRequest request){
        String name = request.getParameter("xm");
        return name + "是第一个访问函数内部的名字";
    }
    @RequestMapping("test_two_param")
    public String testTwoParam(HttpServletRequest request){
        String name = request.getParameter("xm");
        String no = request.getParameter("xh");
        return "学号：" + no + "----姓名：" + name;
    }
    @RequestMapping("test_two_param_json")
    public String testTwoParamJson(HttpServletRequest request){
        String name = request.getParameter("xm");
        String no = request.getParameter("xh");
        return "{xh:" + no + ",xm:" + name + "}";
    }

    @RequestMapping("no_param_json")
    public StuInfo noParamJson(){
        StuInfo stuInfo = new StuInfo();
        stuInfo.setStuNo("111111");
        stuInfo.setStuName("222222");
        stuInfo.setTelephone("1564856");
        stuInfo.setAddress("一号");

        return stuInfo;
    }
}

