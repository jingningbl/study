package com.ssm1.controller;

import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.dto.requestDto.LoginRequestDto;
import com.ssm1.service.EmployeeService;
import com.ssm1.util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author q1425
 */
@Api(tags = "登陆登出")
@Controller
public class IndexController extends BaseController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @return: java.lang.String
     * @description: 登录页面
     */
    @ApiOperation(value = "跳转登录页面")
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * @param loginRequestDto:
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 登录验证
     */
    @ApiOperation(value = "登录验证")
    @PostMapping("/checkLogin")
    @ResponseBody
    public Map<String, Object> checkLogin(@RequestBody LoginRequestDto loginRequestDto) {
        Map<String, Object> modelMap = new HashMap<>();
        //是否需要校验验证码
        Boolean needVerify = loginRequestDto.getNeedVerify();
        //获取验证码
        String verifyCodeActual = loginRequestDto.getVerifyCodeActual();
        //获取用户名
        String username = loginRequestDto.getUsername();
        //获取密码
        String password = loginRequestDto.getPassword();
        /**
         * @param loginRequestDto:
         * @return: java.util.Map<java.lang.String, java.lang.Object>
         * @description: 验证码校验, 未通过
         */
        if (needVerify && !CodeUtil.checkVerifyCode(request, loginRequestDto.getVerifyCodeActual())) {
            //验证码错误
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            return modelMap;
        }
        if ("".equals(username) || "".equals(password)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名或密码不可为空");
        } else {
            //通过用户名密码查库
            EmployeeDto userInfo = employeeService.getEmInfoByUsernameAndPassword(username, password);
            if (null != userInfo) {
                //userInfo不为空,登陆成功
                modelMap.put("success", true);
                modelMap.put("username", userInfo.getName());
                //将信息存入到session
                request.getSession().setAttribute("userInfo", userInfo);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "用户名或者密码错误");
            }
        }
        return modelMap;
    }

    /**
     * @return: java.lang.String
     * @description: 首页
     */
    @ApiOperation(value = "跳转主页面")
    @GetMapping("main")
    public String toMain() {
        request.getSession().setAttribute("pageName", "后台首页");
        return "main";
    }

    /**
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 登出
     */
    @ApiOperation(value = "退出登录")
    @PostMapping("logout")
    @ResponseBody
    public Map<String, Object> logout() {
        Map<String, Object> modelMap = new HashMap<>();
        request.getSession().setAttribute("userInfo", null);
        modelMap.put("success", true);
        return modelMap;
    }
}