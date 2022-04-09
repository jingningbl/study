package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/12 11:26
 * @describe
 */
@WebServlet("/find1")
public class FindServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        resp.setContentType("text/html;charset=utf-8");
//        获得上下文
        ServletContext servletContext = getServletContext();
//        绑定数据
        servletContext.setAttribute("name", "123");
    }
}
