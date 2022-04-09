package com.servlet;

import com.pojo.Song;
import com.service.SongService;
import com.service.SongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @title: DetailsSongServlet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2022/1/4 20:59
 */
@WebServlet("/detailSong")
public class DetailsSongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获得歌曲详情id
        int id=Integer.parseInt(req.getParameter("id"));
        //访问业务层
        SongService songService=new SongServiceImpl();
        Song s=songService.findById(id);
        //绑定数据转发到详情页
        req.setAttribute("s",s);
        req.getRequestDispatcher("details.jsp").forward(req,resp);
    }
}
