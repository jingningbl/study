package com.ruandy.controller;

import com.alibaba.fastjson.JSON;
import com.ruandy.dao.USDao;
import com.ruandy.dao.USDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Administrator
 * @title: DeleteSongSerlvet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2022/1/4 21:24
 */
@WebServlet("/deleteSong")
public class DeleteSongSerlvet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获得id
        int uid = Integer.parseInt(req.getParameter("uid"));
        int sid = Integer.parseInt(req.getParameter("sid"));
        //业务层
        //USService usService=new USServiceImpl();
        USDao usDao = new USDaoImpl();
        boolean flag = usDao.delete(uid, sid);
        //获得输出流,回调json数据
        PrintWriter out = resp.getWriter();
        if (flag) {
            out.println(JSON.toJSONString(true));
        } else {
            out.println(JSON.toJSONString(false));
        }

    }
}
