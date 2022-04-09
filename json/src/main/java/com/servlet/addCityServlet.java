package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.City;

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
 * @date 2022/1/2 10:57
 * @describe
 */
@WebServlet("/addCity")
public class addCityServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String cityStr=req.getParameter("myCity");
        System.out.println(cityStr);
        City city= JSON.parseObject(cityStr,City.class);
        System.out.println(city);
        PrintWriter out=resp.getWriter();
        out.println(JSON.toJSONString(city));
    }
}
