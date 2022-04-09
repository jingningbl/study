package com.servlet;

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
 * @Package com.servlet
 * @date 2021/12/27 14:25
 * @describe
 */
@WebServlet("/loginout")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        resp.setContentType("text/html;charset=utf-8");
//        获取session
        HttpSession session = req.getSession();
//        清空session
        session.invalidate();
//        重定向
        resp.sendRedirect("login.html");
    }
}
