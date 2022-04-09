package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/2 18:03
 * @describe
 */
@WebServlet("/register")
public class RegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        请求编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        UserDao userDao = new UserDaoImpl();

    }
}
