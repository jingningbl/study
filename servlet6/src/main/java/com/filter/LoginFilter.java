package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.filter
 * @date 2021/12/29 11:43
 * @describe
 */
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
////        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
////        获取所有的url
//        String url = request.getRequestURI();
//        if (url.contains("/login") || url.contains("login.html") || url.contains("/regist")) {
////            过滤链
//            filterChain.doFilter(request, response);
//        } else {
////            获取session中的username
//            Object username = session.getAttribute("username");
//            if (username == null) {
////                username为空,重定向登录页面
//                response.sendRedirect("login.html");
//            } else {
//                filterChain.doFilter(request, response);
//            }
//        }
//    }
//
//    @Override
//    public void destroy() {
////        Filter.super.destroy();
//    }
//}
