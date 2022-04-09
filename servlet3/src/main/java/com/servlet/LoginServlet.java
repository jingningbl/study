package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.pojo.User;

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
 * @date 2021/12/3 22:13
 * @describe
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
     * 重写service
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        请求编码
        req.setCharacterEncoding("utf-8");
//        响应编码
        resp.setContentType("text/html;charset=utf-8");
//        获取用户名
        String username=req.getParameter("username");
//        获取密码
        String pwd=req.getParameter("password");
        UserDao userDao=new UserDaoImpl();
//        登录,返回User
        User user=userDao.login(username,pwd);
        if (user!=null){
////            User不空,绑定数据
//            req.setAttribute("user",user);
//            获得上下文
            ServletContext servletContext=getServletContext();
            servletContext.setAttribute("user",user);
//            获取转发器,转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }
    }
}
