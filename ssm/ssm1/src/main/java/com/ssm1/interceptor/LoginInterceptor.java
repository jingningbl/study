package com.ssm1.interceptor;

import com.ssm1.dto.responseDto.EmployeeDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            //在职
            if (userInfo.getEmId() != null && userInfo.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }
}
