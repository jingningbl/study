package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Administrator
 * @title: LogoutServlet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2022/1/6 20:28
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得会话
        HttpSession session=req.getSession();
        session.invalidate();
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("login.html");
    }
}
