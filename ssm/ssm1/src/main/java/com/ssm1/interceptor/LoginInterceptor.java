package com.ssm1.interceptor;

import com.ssm1.dto.responseDto.EmployeeDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: bai
 * @date: 2022/4/17 18:03
 * @description: 登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * @param request:
     * @param response:
     * @param handler:
     * @return: boolean
     * @description: 登录验证
     * toLowerCase:转小写
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session拿到用户信息
        Object userObject = request.getSession().getAttribute("userInfo");
        /*
         * @description: userObject不为空, 判断是否离职
         */
        if (userObject != null) {
            EmployeeDto userInfo = (EmployeeDto) userObject;
            //确保员工id不为空,并且是在职状态
            if (userInfo.getEmId() != null && userInfo.getStatus() == 1) {
                //如果用户已经登录,url为/login或者/,就自动跳转/main
                if (request.getRequestURI().toLowerCase().contains("login") || "/".equals(request.getRequestURI())) {
                    response.sendRedirect("/main");
                    return false;
                }
                return true;
            }
        }
        //如果没有员工信息,url为/login或者/,放行
        if (request.getRequestURI().toLowerCase().contains("login") || "/".equals(request.getRequestURI())) {
            return true;
        }
        //如果没有员工信息,则跳转登录页面
        response.sendRedirect("login");
        /**
         * @param request:
         * @param response:
         * @param handler:
         * @return: boolean
         * @description: 以前的写法
         */
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<script>");
//        //window.open(request.getContextPath()+"/login","_self")
//        writer.println("window.open('"+request.getContextPath()+"/login','_self')");
//        writer.println("</script>");
//        writer.println("</html>");
        return false;
    }
}
