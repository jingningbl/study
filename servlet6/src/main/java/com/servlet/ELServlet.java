package com.servlet;

import com.pojo.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/7 21:46
 * @describe
 */
@WebServlet("/myel")
public class ELServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
//        song对象
        Song song1=new Song(1,"Stuck in陷入","XMASwu", "Stuck in陷入","流行",
                "D:\\QQ音乐\\本地音乐\\Stuck in陷入.mp3",15461,new Timestamp(new Date().getTime()));
        Song song2=new Song(1,"Stuck in陷入","XMASwu", "Stuck in陷入","流行",
                "D:\\QQ音乐\\本地音乐\\Stuck in陷入.mp3",15461,new Timestamp(new Date().getTime()));
//        list对象
        List<Song> list=new ArrayList<>();
        list.add(song1);
        list.add(song2);
//        数组
        Song[] arr= {song1,song2};
//        绑定数据
        req.setAttribute("song1",song1);
        req.setAttribute("song2",song2);
        req.setAttribute("list",list);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
