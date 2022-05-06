package com.springMVC.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springMVC.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @date 2021/10/8 -15:29
 */
public class testObjectToJson extends HttpServlet {
    //    创建ObjectMapper对象
    public static ObjectMapper mapper = new ObjectMapper();
    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    //测试类

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean userBean=new UserBean(110,"lin",0);
        //        将学生对象转换为json格式数据
        String jsonStu= mapper.writeValueAsString(userBean);
        System.out.println(jsonStu);
        resp.getWriter().print(jsonStu);
    }
}
