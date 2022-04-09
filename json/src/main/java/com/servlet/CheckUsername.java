package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2022/1/2 9:40
 * @describe
 */
@WebServlet("/checkUsername")
public class CheckUsername extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username=req.getParameter("username");
        PrintWriter out=resp.getWriter();
        if ("张三".equals(username)){
//            使用json将java的对象转为Json字符串
//            out.println(JSON.toJSONString(false));
            City city1=new City("wuhan","武汉");
            out.println(JSON.toJSONString(city1));
        }else {
            City city2=new City("gz","广州");
            out.println(JSON.toJSONString(city2));
        }
    }
}
