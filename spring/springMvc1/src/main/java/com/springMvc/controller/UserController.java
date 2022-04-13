package com.springMvc.controller;

import com.springMvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author bai
 * @version V1.0
 * @Package com.springMvc.controller
 * @date 2022/2/28 19:16
 * @describe
 */
@Controller
@RequestMapping("user")
@SessionAttributes({"user"})
public class UserController {
    @PostMapping("getData")
    public String getData(User user, Model model) {
        model.addAttribute("user", user);
        return "/loginSuccess.jsp";
    }
}
