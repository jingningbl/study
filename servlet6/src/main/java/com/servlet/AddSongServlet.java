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
import java.util.Date;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/7 20:39
 * @describe
 */
@WebServlet("/addSong")
public class AddSongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        请求响应的编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获得请求的参数
        String name = req.getParameter("name");
        String singer = req.getParameter("singer");
        String album = req.getParameter("album");
        String style = req.getParameter("style");
        Timestamp uploadTime = new Timestamp(new Date().getTime());
        String location = "D:\\QQ音乐\\本地音乐\\" + name;
        long size = 32412;
        Song song = new Song(1, name, singer, album, style, location, size, uploadTime);
        SongDao songDao = new SongDaoImpl();
        boolean flag = songDao.save(song);
//        返回结果不空,添加成功,重定向
        if (flag) {
            resp.sendRedirect("find2");
        }
    }
}
