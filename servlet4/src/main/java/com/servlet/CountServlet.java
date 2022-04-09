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
 * @date 2021/12/12 11:35
 * @describe
 */
@WebServlet("/count")
public class CountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获得上下文
        ServletContext servletContext = getServletContext();
//        获得绑定的数据
        Object count = servletContext.getAttribute("mycount");
        if (count == null) {
//            count为空,第一次登录,绑定mycount为1
            servletContext.setAttribute("mycount", 1);
        } else {
//            如果不为空,mycount+1
            int num = Integer.parseInt(count.toString());
            servletContext.setAttribute("mycount", num + 1);
        }
//        响应到浏览器
        resp.getWriter().println("当前在线人数:" + servletContext.getAttribute("mycount"));
    }
}
