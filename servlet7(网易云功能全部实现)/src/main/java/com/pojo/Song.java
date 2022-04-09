package com.pojo;

import java.sql.Timestamp;

/**
 * @author Administrator
 * @title: Song
 * @projectName vip2105
 * @description: 数据类型映射尽量和数据库保持一致
 * @date 2021/11/19 20:32
 */
public class Song {
    private int id;
    private String name;//歌名
    private String singer;//歌手
    private String album;//专辑
    private String style;//风格
    private long size;
    private String location;
    private Timestamp uploadTime;

    public Song(int id, String name, String singer, String album, String style, long size, String location, Timestamp uploadTime) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.style = style;
        this.size = size;
        this.location = location;
        this.uploadTime = uploadTime;
    }

    public Song() {
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", album='" + album + '\'' +
                ", style='" + style + '\'' +
                ", size=" + size +
                ", location='" + location + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
