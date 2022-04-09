package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/15 10:24
 * @describe
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        用户名
        String username = req.getParameter("username");
//        密码
        String pwd = req.getParameter("password");
//        勾选框
        String check = req.getParameter("mycheckbox");
//        登陆成功
        if (username.equals("kunkun") && pwd.equals("123456")) {
//            勾选记住密码
            if (check.equals("on")) {
//                添加cookie
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("pwd", pwd);
                Cookie cookie3 = new Cookie("mycheckbox", check);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                resp.addCookie(cookie3);
            }
        }
    }
}
