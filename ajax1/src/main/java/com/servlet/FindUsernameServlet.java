package com.servlet;

import com.alibaba.fastjson.JSON;

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
 * @date 2022/1/1 9:37
 * @describe
 */
@WebServlet("/findUsername")
public class FindUsernameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获取用户名
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        if ("张三".equals(username)) {
//            out.println("0");
            out.println(JSON.toJSONString(true));
        } else {
//            out.println("1");
            out.println(JSON.toJSONString(false));
        }
    }
}
