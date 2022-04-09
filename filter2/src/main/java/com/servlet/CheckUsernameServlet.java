package com.servlet;

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
 * @date 2021/12/30 11:56
 * @describe
 */
@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获得异步请求绑定的参数
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        if ("张三".equals(username)) {
            out.println("0");
        } else {
            out.println("1");
        }
    }
}
