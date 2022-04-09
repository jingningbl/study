package com.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * @author Administrator
 * @title: VerifyCodeUtils
 * @projectName vip2105-web
 * @description: 生成验证码的工具类
 *         Map<图片,内容>
 * @date 2021/12/23 20:29
 */
public class VerifyCodeUtils {
    /**
     * 获得一个键值对 <验证码图片,图片内容>
     * @return
     */
    public static Map<BufferedImage,String> getMap(){
        Map<BufferedImage,String> map=new HashMap<>();
        //1.构建一个图片:rgb  透明100*50
        BufferedImage image=new BufferedImage(100,50,BufferedImage.TYPE_3BYTE_BGR);
        //2.获得画笔
        Graphics g=image.getGraphics();
        //3.设置画笔颜色
        g.setColor(Color.white);
        //4.设置图片的背景色为白色
        g.fillRect(0,0,100,50);
        //5.设置画笔颜色
        g.setColor(Color.black);
        //6.绘制边框
        g.drawRect(0,0,99,49);
        //7.随机数对象
        Random r=new Random();
        //8.构建字符对象
        StringBuffer sb=new StringBuffer();
        //9.随机写进去四个字符
        //设置字体
        Font f=new Font("隶书",Font.BOLD,25);
        g.setFont(f);
        for (int i = 0; i < 4; i++) {
            char ch= (char) (65+r.nextInt(26));//[65,90]
            //随机颜色: R256  G256   B256
            Color c=new Color(r.nextInt(256),
                    r.nextInt(256),r.nextInt(256));
            g.setColor(c);
            //将字符画到图片上
            g.drawString(ch+"",25*i,30);
            //添加到字符到sb中
            sb.append(ch);
        }
        //添加到map中
        map.put(image,sb.toString());
        return map;
    }

    /**
     * 封装解析map的方法1
     * @param map
     * @return 图片
     */
    public static BufferedImage getImage(Map<BufferedImage,String> map){
        //得到键值对集合
        Set<Map.Entry<BufferedImage, String>> set=map.entrySet();
        //获得迭代器
        Iterator<Map.Entry<BufferedImage, String>> it=set.iterator();
        //由于map中只有一组值
        //可以直接获取当前键值对
        Map.Entry<BufferedImage, String> entry=it.next();
        return entry.getKey();
    }
    /**
     * 封装解析map的方法2
     * @param map
     * @return 返回内容
     */
    public static String getCode(Map<BufferedImage,String> map){
        //得到键值对集合
        Set<Map.Entry<BufferedImage, String>> set=map.entrySet();
        //获得迭代器
        Iterator<Map.Entry<BufferedImage, String>> it=set.iterator();
        //由于map中只有一组值
        //可以直接获取当前键值对
        Map.Entry<BufferedImage, String> entry=it.next();
        return entry.getValue();
    }
}
