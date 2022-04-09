package com.servlet;

import com.dao.SongDao;
import com.dao.SongDaoImpl;
import com.pojo.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/10 19:03
 * @describe
 */
@WebServlet("/updateSong")
public class UpdateSongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获取请求参数
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String singer = req.getParameter("singer");
        String album = req.getParameter("album");
        String style = req.getParameter("style");
        String location = req.getParameter("location");
        long size = Long.parseLong(req.getParameter("size"));
        Timestamp uploadTime = Timestamp.valueOf(req.getParameter("uploadTime"));
//        创建对象
        Song song = new Song(id, name, singer, album, style, location, size, uploadTime);
        SongDao songDao = new SongDaoImpl();
        boolean flag = songDao.update(song);
//        返回结果不为空,修改成功,请求转发
        if (flag) {
            resp.sendRedirect("find2");
        }
    }
}
