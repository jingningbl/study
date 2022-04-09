package com.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author bai
 * @version V1.0
 * @Package com.filter
 * @date 2021/12/29 11:32
 * @describe
 */
@WebListener
public class SessionListener implements HttpSessionListener {
//    创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        HttpSessionListener.super.sessionCreated(se);
    }
//    销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
//        HttpSessionListener.super.sessionDestroyed(se);
    }
}
