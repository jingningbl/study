package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author bai
 * @version V1.0
 * @Package com.listener
 * @date 2021/12/29 12:39
 * @describe
 */
@WebListener
public class CountListener implements HttpSessionListener {
    private int count=0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建中");
        count++;
        HttpSession session=se.getSession();
        ServletContext servletContext=session.getServletContext();
        servletContext.setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁中");
        count--;
        HttpSession session=se.getSession();
        ServletContext servletContext=session.getServletContext();
        servletContext.setAttribute("count",count);
    }
}
