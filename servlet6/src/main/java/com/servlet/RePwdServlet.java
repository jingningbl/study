package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/27 14:29
 * @describe
 */
@WebServlet("/repwd")
public class RePwdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        获取用户名和密码以及id
        String username = req.getParameter("username");
        String pwd = req.getParameter("newpwd");
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDaoImpl();
//        获取执行结果
        boolean flag = userDao.rePwd(username, pwd);
        if (flag) {
            User user = new User(id, username, pwd);
//            获取session
            HttpSession session = req.getSession();
//            绑定会话
            session.setAttribute("user", user);
//            重定向
            resp.sendRedirect("repassword.jsp");
        }
    }
}
