package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author bai
 * @version V1.0
 * @Package com.controller
 * @date 2021/12/2 13:08
 * @describe
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        1.设置请求编码
        request.setCharacterEncoding("utf-8");
//        如果是网页,根据name属性
//        如果是url:http://localhost:8080/servlet1/fir?key1=value1&&key2=value2
//        2.获得请求的参数
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        String[] hobbys=request.getParameterValues("hobby");
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(Arrays.toString(hobbys));
//        获得请求的一些参数
        System.out.println("服务器名:"+request.getServerName());
        System.out.println("协议:"+request.getProtocol());
        System.out.println("端口:"+request.getServerPort());
        System.out.println("应用名:"+request.getContextPath());
        System.out.println("应用名+请求名:"+request.getRequestURI());
        System.out.println("url请求地址:"+request.getRequestURL());
        System.out.println("判断地址是否安全:"+request.isSecure());
    }
}
