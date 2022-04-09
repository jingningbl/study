package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/15 9:29
 * @describe
 */
@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Cookie cookie1=new Cookie("beauty","yuanyuan");
        Cookie cookie2=new Cookie("mengnan","kunkun");
        Cookie cookie3=new Cookie("boy", URLEncoder.encode("苏妍","utf-8"));
//        >0 Cookie保存在硬盘.持久化
//        <0 Cookie保存在内存
//        =0 删除Cookie
        cookie1.setMaxAge(13);

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
    }
}
