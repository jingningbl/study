package com.servlet;

import com.dao.SongDao;
import com.dao.SongDaoImpl;
import com.pojo.Song;
import com.pojo.User;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/3 21:12
 * @describe
 */
@WebServlet("/findAllSong")
public class FindAllSongServlet extends HttpServlet {
    /**
     * 重写service
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        请求编码
        req.setCharacterEncoding("utf-8");
//        响应编码
        resp.setContentType("text/html;charset=utf-8");
//        获取起始页码
        String num=req.getParameter("pageNum");
//        页码为空则默认1
        int pageNum=(num==null?1:Integer.parseInt(num));
//        行数
        int pageSize=3;
        SongDao songDao=new SongDaoImpl();
//        查询全部被歌曲,返回list集合
        List<Song> list=songDao.findAll(pageNum,pageSize);
        PrintWriter out=resp.getWriter();
//        获取绑定的数据
        User user= (User) req.getAttribute("user");
//        out.println("亲爱的"+user.getUsername()+",欢迎您的登录");
        printData(out,list);
    }

    /**
     * 封装方法将内容写到网页
     * @param out
     * @param list
     */
    private void printData(PrintWriter out, List<Song> list) {
        out.println("<h2>音乐</h2>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>序号</td><td>歌名</td><td>歌手</td><td>专辑</td><td>风格</td><td>路径</td><td>大小</td><td>上传时间</td>");
        out.println("</tr>");
//        遍历list集合
        for (int i = 0; i < list.size(); i++) {
            Song song=list.get(i);
            out.println("<tr>");
            out.println("<td>"+song.getId()+"</td><td>"+song.getName()+"</td><td>"+song.getSinger()+"</td>" +
                    "<td>"+song.getAlbum()+"</td><td>"+song.getStyle()+"</td>" +
                    "<td>"+song.getLocation()+"</td><td>"+song.getSize()+"</td><td>"+song.getUploadTime()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
