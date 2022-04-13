package com.springMvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.interceptor
 * @date 2022/3/9 14:56
 * @describe 自定义拦截器
 */
//@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 前置处理方法
     *
     * @param request
     * @param response
     * @param handler
     * @return 布尔类型 true代表放行,false代表被打回
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(LocalDateTime.now() + "preHandle被触发了" + request.getRequestURI() + "被拦截了");
        System.out.println("客户端环境:" + request.getHeader("User-Agent"));
        System.out.println("请求来自哪个ip:" + request.getRemoteHost());
        return true;
    }

    /**
     * 目标资源在被SpringMvc处理之后(Controller中执行return)/或者被HttpServletResponse处理之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle被触发了" + request.getRequestURI() + "被拦截了");
    }

    /**
     * 产生响应的文本(html页面)/或者数据被序列化之后/或者被视图解析器处理之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion被触发了" + request.getRequestURI() + "被拦截了");
    }
}
