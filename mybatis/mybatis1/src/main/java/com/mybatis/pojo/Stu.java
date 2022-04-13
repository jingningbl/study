package com.mybatis.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.pojo
 * @date 2022/3/11 12:14
 * @describe
 */
public class Stu {
    private int sid;
    private String sname;
    private String age;
    private String course;
    private StuCard sc;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public StuCard getSc() {
        return sc;
    }

    public void setSc(StuCard sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age='" + age + '\'' +
                ", course='" + course + '\'' +
                ", sc=" + sc +
                '}';
    }
}
