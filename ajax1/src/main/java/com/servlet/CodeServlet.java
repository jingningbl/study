package com.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2022/1/1 12:57
 * @describe
 */
@WebServlet("/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String code2 = req.getParameter("code2");
        HttpSession session = req.getSession();
        String code1 = (String) session.getAttribute("code1");
        PrintWriter out = resp.getWriter();
        if (code1.equalsIgnoreCase(code2)) {
//            out.println("1");
            out.println(JSON.toJSONString(true));
        } else {
//            out.println("0");
            out.println(JSON.toJSONString(false));
        }
    }
}
