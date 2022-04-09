package com.pojo;

import java.sql.Timestamp;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2021/12/7 15:31
 * @describe
 */
public class Song {
    private int id;
    private String name;
    private String singer;
    private String album;
    private String style;
    private String location;
    private long size;
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

    @Override
    public String toString() {
        return id + "\t" +
                name + "\t" +
                singer + "\t" +
                album + "\t" +
                style + "\t" +
                location + "\t" +
                size + "\t" +
                uploadTime + "\n";
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
}
