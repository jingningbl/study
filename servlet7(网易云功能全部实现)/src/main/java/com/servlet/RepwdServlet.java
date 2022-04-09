package com.servlet;

import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Administrator
 * @title: RepwdServlet
 * @projectName vip2105-web
 * @description: TODO
 * @date 2022/1/6 20:17
 */
@WebServlet("/repwd")
public class RepwdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获得参数
        String username=req.getParameter("username");
        String rePwd=req.getParameter("newpwd");
        int id=Integer.parseInt(req.getParameter("id"));
        //访问业务层
        UserService userService=new UserServiceImpl();
        boolean flag=userService.rePwd(username,rePwd);
        //获得会话
        HttpSession session=req.getSession();
        if(flag){
            User u=new User(id,username,rePwd);
            session.setAttribute("u",u);
            req.getRequestDispatcher("modifySuccess.jsp").forward(req,resp);
        }
    }
}
