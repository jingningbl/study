package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2021/12/7 15:37
 * @describe
 */
public class Us {
    private int id;
    private int uid;
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
