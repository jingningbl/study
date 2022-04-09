package com.ruandy.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;


/**
 * @author bai
 * @version V1.0
 * @Package com.utils
 * @date 2022/1/1 10:50
 * @describe 绘制验证码
 */
public class CodeUtils {
    /**
     * 获得键值对<验证码图片,图片内容>
     *
     * @return
     */
    public static Map<BufferedImage, String> getMap() {
        Map<BufferedImage, String> map = new HashMap<>();
//        构建一个图片:rgb
        BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_3BYTE_BGR);
//        获得画笔
        Graphics graphics = image.getGraphics();
//        画笔颜色
        graphics.setColor(Color.white);
//        图片的背景色
        graphics.fillRect(0, 0, 60, 20);
        graphics.setColor(Color.black);
//        绘制边框
        graphics.drawRect(0, 0, 59, 19);
        //        随机数对象
        Random random = new Random();
//        构建字符对象
        StringBuffer stringBuffer = new StringBuffer();
//        随机写进4个字符
        for (int i = 0; i < 4; i++) {
            char ch = (char) (65 + random.nextInt(26));
//            随机颜色:R256 G256 B256
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            graphics.setColor(color);
//            设置字体
            Font font = new Font("隶书", Font.BOLD, 25);
//            字符画到图片上
            graphics.drawString(ch + "", 3 + 15 * i, 15);
            stringBuffer.append(ch);
        }
        map.put(image, stringBuffer.toString());
        return map;
    }

    public static BufferedImage getImage(Map<BufferedImage, String> map) {
//        获得键值对
        Set<Map.Entry<BufferedImage, String>> set = map.entrySet();
//        获得迭代器
        Iterator<Map.Entry<BufferedImage, String>> iterable = set.iterator();
//        获取当前键值对
        Map.Entry<BufferedImage, String> entry = iterable.next();
        return entry.getKey();
    }

    public static String getCode(Map<BufferedImage, String> map) {
//        获得键值对
        Set<Map.Entry<BufferedImage, String>> set = map.entrySet();
//        获得迭代器
        Iterator<Map.Entry<BufferedImage, String>> iterable = set.iterator();
//        获取当前键值对
        Map.Entry<BufferedImage, String> entry = iterable.next();
        return entry.getValue();
    }
}
