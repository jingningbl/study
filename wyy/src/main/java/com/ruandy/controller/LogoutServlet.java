package com.ruandy.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.ruandy.controller
 * @date 2022/1/19 10:58
 * @describe
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获得会话
        HttpSession session = req.getSession();
//        清空session
        session.invalidate();
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("login.html");
    }
}
