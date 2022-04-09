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
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/9 20:14
 * @describe
 */
@WebServlet("/find2")
public class FindAllSongServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        起始页
        String num = req.getParameter("pageNum");
        int pageNum = (num == null ? 1 : Integer.parseInt(num));
//        行数
        int pageSize = 20;
        SongDao songDao = new SongDaoImpl();
//        全部歌曲
        List<Song> list = songDao.findAll(pageNum, pageSize);
//        绑定数据
//        req.setAttribute("list", list);
        ServletContext servletContext=getServletContext();
        servletContext.setAttribute("list",list);
//        转发
        req.getRequestDispatcher("music_list.jsp").forward(req, resp);
    }
}
