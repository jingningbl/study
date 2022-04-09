package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bai
 * @version V1.0
 * @Package com.filter
 * @date 2021/12/29 9:33
 * @describe
 */
//过滤多个
//@WebFilter(urlPatterns = {"/login","/regist",...})
@WebFilter("/regist")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        获取外部配置
        String encoding = filterConfig.getInitParameter("myencoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("执行了过滤器");
//        编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        过滤链
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
