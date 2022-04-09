package com.pojo;

/**
 * @author:Administrator
 * @data:2021/11/27
 * @description:
 */
public class Us {
    //    关联的id
    private int id;
    //    用户id
    private int uid;
    //    歌曲id
    private int sid;

    public Us() {
    }

    public Us(int id, int uid, int sid) {
        this.id = id;
        this.uid = uid;
        this.sid = sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
