package com.pojo;


import java.sql.Timestamp;

/**
 * @author:Administrator
 * @data:2021/11/27
 * @description:
 */
public class Song {
    //    歌曲id
    private int id;
    //    歌名
    private String name;
    //    歌手
    private String singer;
    //    专辑
    private String album;
    //    风格
    private String style;
    //    路径
    private String location;
    //    大小
    private long size;
    //    上传时间
    private Timestamp uploadTime;

    public Song() {
    }

    public Song(int id, String name, String singer, String album, String style, String location, long size, Timestamp uploadTime) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.style = style;
        this.location = location;
        this.size = size;
        this.uploadTime = uploadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + singer + "\t" + album + "\t" + style + "\t" + location + "\t" + size + "\t" + uploadTime + "\n";
    }
}
