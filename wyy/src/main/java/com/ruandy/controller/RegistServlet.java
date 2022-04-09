package com.ruandy.controller;

import com.alibaba.fastjson.JSON;
import com.ruandy.pojo.User;
import com.ruandy.service.UserService;
import com.ruandy.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Administrator
 * @title: RegistServlet
 * @projectName vip2105-web
 * @description: 注册Servlet
 * @date 2021/12/28 20:17
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取参数
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        User u=new User(1,username,pwd);
        //处理参数-dao--->service
        //依赖的是 service层对象
        UserService userService=new UserServiceImpl();
        boolean flag=userService.add(u);
        //响应
        //PrintWriter out=resp.getWriter();
        //out.println(JSON.toJSONString(flag));
        if(flag){
            resp.sendRedirect("login.html");
        }else{
            resp.sendRedirect("reg.html");
        }
    }
}
