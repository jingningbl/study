package com.pojo;

/**
 * @author Administrator
 * @title: US
 * @projectName vip2105
 * @description: TODO
 * @date 2021/11/26 21:50
 */
public class US {
    private int id;
    private int uid;
    private int sid;

    public US(int id, int uid, int sid) {
        this.id = id;
        this.uid = uid;
        this.sid = sid;
    }
    public US(){}

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
