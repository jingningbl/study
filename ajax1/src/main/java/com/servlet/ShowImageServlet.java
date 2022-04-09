package com.servlet;

import com.utils.CodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author bai
 * @version V1.0
 * @Package com.servlet
 * @date 2022/1/1 11:41
 * @describe
 */
@WebServlet("/showImage")
public class ShowImageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        响应类型
        resp.setContentType("image/jpeg");
//        获得图片和文字
        Map<BufferedImage, String> map = CodeUtils.getMap();
//        获取图片
        BufferedImage image = CodeUtils.getImage(map);
//        获取验证码
        String code1 = CodeUtils.getCode(map);
//        获取session
        HttpSession session = req.getSession();
//        绑定会话
        session.setAttribute("code1", code1);
//        获得输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
    }
}
