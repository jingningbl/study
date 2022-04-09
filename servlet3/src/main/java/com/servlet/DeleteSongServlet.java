package com.servlet;

import com.dao.SongDao;
import com.dao.SongDaoImpl;

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
 * @date 2021/12/10 19:40
 * @describe
 */
@WebServlet("/deleteSong")
public class DeleteSongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        歌曲id
        int id = Integer.parseInt(req.getParameter("id"));
        SongDao songDao = new SongDaoImpl();
        boolean flag = songDao.delete(id);
//        返回结果不空,删除成功,重定向
        if (flag) {
            resp.sendRedirect("find2");
        }
    }
}
