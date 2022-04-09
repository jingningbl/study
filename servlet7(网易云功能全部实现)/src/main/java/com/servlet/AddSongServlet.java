package com.servlet;

import com.pojo.Song;
import com.service.SongService;
import com.service.SongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Administrator
 * @title: AddSongServlet
 * @projectName vip2105-web
 * @description: 添加歌曲
 * @date 2021/12/30 21:24
 */
@MultipartConfig
@WebServlet("/addSong")
public class AddSongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //上传文件,获得歌曲对象
        Song s=uploadSong(req);
        //访问业务层,插入歌曲
        SongService songService=new SongServiceImpl();
        boolean flag=songService.add(s);
        //跳转网页
        req.getRequestDispatcher("addSuccess.jsp").forward(req,resp);
    }

    /**
     * 封装上传文件操作
     * @param req
     * @return 上传的歌曲对象
     * @throws IOException
     */
    private Song uploadSong(HttpServletRequest req) throws IOException, ServletException {
        //1.获得请求头封装的part对象
        //part对象本身不能直接获取文件名,但是可以得到文件头信息
        Part part=req.getPart("file1");//参数就是对应文件input name属性
        //2.根据part获得请求头信息里面文件文件的上传信息 K-v
        //String message=part.getHeader("Content-Disposition");
        //form-data; name="file1"; filename="曾经的你.mp3"
        //可以通过截取...去获取
        //message=message.substring(message.lastIndexOf("=")+1);//"曾经的你.mp3"
        //String name=message.substring(1,message.lastIndexOf("."));//曾经的你
        //歌曲名
        String name=req.getParameter("songName");
        String singer=req.getParameter("singer");
        String album=req.getParameter("album");
        String style=req.getParameter("style");

        //获得输入流
        InputStream in=part.getInputStream();
        //获得输出流文件夹
        File file=new File("D:\\QQ音乐\\本地音乐\\"+singer);
        if(!file.exists()) {//给每一个歌手创立单独的文件夹
            file.mkdirs();
        }
        String fileName=name+".mp3";
        //d://upload_02//许巍//曾经的你.mp3
        FileOutputStream fos=new FileOutputStream("D:\\QQ音乐\\本地音乐\\"+singer+File.separator+fileName);
        //读写操作
        byte[] bs=new byte[512];
        int len=0;
        while((len=in.read(bs))!=-1){
            fos.write(bs,0,len);
            //计数
        }
        //关闭
        fos.close();
        in.close();
        //路径
        String location="D:\\QQ音乐\\本地音乐\\"+singer+File.separator+fileName;
        //通过文件的对象length方法
        long size=new File(location).length();
        //上传时间
        Timestamp uploadTime=new Timestamp(new Date().getTime());
        //构建歌曲对象
        Song s=new Song(1,name,singer,album,style,size,location,uploadTime);
        return s;
    }
}
