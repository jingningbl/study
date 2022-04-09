package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/15 9:42
 * @describe
 */
@WebServlet("/findCookie")
public class FindCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        Cookie[] cookies=req.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                String name=cookie.getName();
                String value=cookie.getValue();
                value= URLDecoder.decode(value,"utf-8");
                if (value.equals("苏妍")){
                    cookie.setValue(URLEncoder.encode("小白","utf-8"));
                    resp.addCookie(cookie);
                }
                out.println("<h3>set-Cookie:"+name+"="+value+"</h3><br>");
            }
        }
    }
}
