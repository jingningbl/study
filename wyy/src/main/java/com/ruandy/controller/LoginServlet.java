package com.ruandy.controller;

import com.alibaba.fastjson.JSON;
import com.ruandy.pojo.Song;
import com.ruandy.pojo.User;
import com.ruandy.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Administrator
 * @title: LoginServlet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2021/12/30 20:04
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //获得请求参数
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
//        值为on表示勾选了记住密码
        String remb=req.getParameter("remb");
        //访问用户业务层
        UserService userService=new UserServiceImpl();
        User u=userService.login(username,pwd);
        //判定:u!=null.登录成功,并且需要获得当前用户关联的歌曲id-->歌曲对象
        //    u==null 登录失败
        if(u==null){
            out.println(JSON.toJSONString(false));
        }else{
           //根据用户id--->获取关联的歌曲对象
            List<Song> songs=findSongsByid(u.getId());
            //使用会话绑定数据
            HttpSession session=req.getSession();
            session.setAttribute("u",u);
            session.setAttribute("songs",songs);
            if ("on".equals(remb)){
                rembPwd(username,pwd,remb,resp);
            }
            //如果不是异步,,转发到main.jsp
            out.println(JSON.toJSONString(true));
        }

    }

    /**
     * 封装登陆成功后的cookie
     * @param username
     * @param pwd
     * @param remb
     * @param resp
     */
    private void rembPwd(String username, String pwd, String remb, HttpServletResponse resp) throws UnsupportedEncodingException {
        Cookie cookie1=new Cookie("username", username);
        Cookie cookie2=new Cookie("pwd",pwd);
        Cookie cookie3=new Cookie("remb",remb);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
    }

    private List<Song> findSongsByid(int id) {
        //访问USService业务层--->歌曲id的集合
        USService usService=new USServiceImpl();
        List<Integer> sids=usService.getSongIdsByUid(id);
        //访问SongService业务层--->根据歌曲id--->歌曲集合
        SongService songService=new SongServiceImpl();
        List<Song> songs=songService.findByIds(sids);
        return songs;
    }
}
