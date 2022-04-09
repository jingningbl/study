package com.servlet;

import com.dao.SongDao;
import com.dao.SongDaoImpl;
import com.pojo.Song;

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
 * @date 2021/12/10 17:30
 * @describe
 */
@WebServlet("/loadSong")
public class LoadSongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        歌曲id
        int id = Integer.parseInt(req.getParameter("id"));
//        对象
        SongDao songDao = new SongDaoImpl();
        Song song = songDao.findSongById(id);
//        数据绑定
//        req.setAttribute("song", song);
        ServletContext servletContext=getServletContext();
        servletContext.setAttribute("song",song);
//        转发
        req.getRequestDispatcher("details.jsp").forward(req, resp);
    }
}
