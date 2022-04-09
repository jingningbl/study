package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bai
 * @version V1.0
 * @Package com.controller
 * @date 2021/12/2 11:53
 * @describe
 */
@WebServlet("/fir")
public class servlet1 extends HttpServlet {
    /**
     *
     * @param request 请求 InputStream-读
     * @param response 响应 OutputStream-写
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        设置响应类型和编码
        response.setContentType("text/html;charset=utf-8");
//        写一串数据到网页
        PrintWriter out=response.getWriter();
        out.println("Hello world");
        out.println("<img src='http://localhost:8080/img1/美女.jpg'>");
    }
}
