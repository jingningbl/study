package com.pojo;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/15 21:18
 * @describe
 */
public class Male {
    private String name;
    private Female female;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Female getFemale() {
        return female;
    }

    public void setFemale(Female female) {
        this.female = female;
    }

    @Override
    public String toString() {
        return "Male{" +
                "name='" + name + '\'' +
                ", female=" + female +
                '}';
    }
}
