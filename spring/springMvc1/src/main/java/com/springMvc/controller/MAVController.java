package com.springMvc.controller;

import com.springMvc.pojo.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/3/2 20:08
 * @describe
 */
@Controller
@RequestMapping("mav")
//热部署不太支持,需要重启服务器
@SessionAttributes({"form", "userInfo"})
public class MAVController {
    /**
     * @param form
     * @return ModelAndView
     */
    @PostMapping("getData1")
    public ModelAndView getData1(Form form) {
        ModelAndView mav = new ModelAndView();
//        /(这里是webapp)代表绝对定位,定位视图
        mav.setViewName("/mav.jsp");
        mav.addObject(form);
        return mav;
    }

    @GetMapping("getData2")
    public String getData2(Form form, ModelMap modelMap) {
        modelMap.addAttribute("form", form);
        return "/mav.jsp";
    }

    @GetMapping("getData3")
    public String getData3(Form form, Model model) {
        form.setUsername("木子");
        model.addAttribute("form", form);
        return "/mav.jsp";
//        不加/为相对路径,,需要在webapp下创建类的映射路径(mav)同名的目录
//        将返回视图的文件的名字在该路径下创建,或者../
//        return "mav.jsp";
        //        return "../mav.jsp";
//        重定向
//        return "redirect:/mav.jsp";
    }

    /**
     * application.xml中进行视图解析器文件的前后缀拼接
     * 使用请求转发前缀forward即可
     *
     * @param form
     * @param modelMap
     * @return
     */
    @GetMapping("getData4")
    public String getData4(Form form, ModelMap modelMap) {
        modelMap.addAttribute("form", form);
//        return "/mav";
        return "forward:/mav.jsp";
    }
}
