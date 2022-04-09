package com.ruandy.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Administrator
 * @title: DownloadServlet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2022/1/4 20:17
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应对象
        req.setCharacterEncoding("utf-8");
        //resp.setContentType("text/html;charset=utf-8");
        //获得请求下载的url
        String name = req.getParameter("name");
        name = name + ".mp3";
        //设置响应的类型:
        resp.setHeader("Content-Disposition",
                "attachment; filename=" + URLEncoder.encode(name, "utf-8"));
        //此路径已经被idea设置为服务器加载的目录(服务器位置指定官方合作伙伴)
        FileInputStream fis = new FileInputStream(name);
        ServletOutputStream sos = resp.getOutputStream();
        //读写操作
        int len = 0;
        byte[] bs = new byte[512];
        while ((len = fis.read(bs)) != -1) {
            sos.write(bs, 0, len);
        }
        sos.close();
        fis.close();
    }
}
