package com.servlet;

import com.alibaba.fastjson.JSON;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Administrator
 * @title: FindByUsernameServlet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/28 21:05
 */
@WebServlet("/findByUsername")
public class FindByUsernameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取参数
        String username=req.getParameter("username");
        //响应输出流
        PrintWriter out=resp.getWriter();
        //访问业务层:后期构建对象---spring容器
        UserService userService=new UserServiceImpl();
        boolean flag=userService.findByUsername(username);
        //输出
        out.println(JSON.toJSONString(flag));
    }
}










