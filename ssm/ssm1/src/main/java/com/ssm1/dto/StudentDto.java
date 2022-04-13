package com.ssm1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author bai
 * @version V1.0
 * @Package com.ssm1.dto
 * @date 2022/3/27 9:10
 * @describe
 */
@ApiModel(description = "课程传输对象")
public class StudentDto implements Serializable {

    private static final long serialVersionUID = -4269401438965091468L;
    //测试的数据example
    @ApiModelProperty(value = "主键id", required = true, example = "2")
    private Integer id;
    @ApiModelProperty(value = "姓名", required = false, example = "张三")
    private String name;
    @ApiModelProperty(value = "年龄", required = false, example = "14")
    private Integer age;
    @ApiModelProperty(value = "班级id", required = false, example = "2")
    private Integer classId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
