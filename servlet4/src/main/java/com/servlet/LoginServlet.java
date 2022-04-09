package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2021/12/12 10:10
 * @describe
 */
@WebServlet(value = "/login", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "encoding", value = "utf-8"),
        @WebInitParam(name = "age", value = "20")
})
public class LoginServlet extends HttpServlet {
    int i = 1;

    /**
     * 实例化
     */
    public LoginServlet() {
        System.out.println("实例化过程");
    }

    /**
     * 初始化
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        ServletConfig servletConfig = getServletConfig();
//        获取初始化配置
        String encoding = servletConfig.getInitParameter("encoding");
        String age = servletConfig.getInitParameter("age");
//        输出
        System.out.println(encoding + "," + Integer.parseInt(age));
        System.out.println("初始化");
    }

    /**
     * 就绪
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected synchronized void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("业务");
//        锁对象
        ReentrantLock reentrantLock = new ReentrantLock();
//        加锁
//        reentrantLock.lock();
        try {
            i++;
            System.out.println(i);
        } finally {
//            解锁
//            reentrantLock.unlock();
        }
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
