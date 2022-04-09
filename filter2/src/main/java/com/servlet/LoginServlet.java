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
 * @date 2021/12/29 12:53
 * @describe
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        if ("张三".equals(username)&&"123456".equals(pwd)){
            HttpSession session=req.getSession();
            session.setAttribute("username",username);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
