package com.mybatis.mapper;

import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.mapper
 * @date 2022/3/18 10:08
 * @describe
 */
public interface StudentMapper {
    @Select("select * from student3 where id = #{id}")
    Student selectStudent(String id);

    @SelectKey(statement = "select max(id) from student3", keyProperty = "id", keyColumn = "id", before = true, resultType = String.class)
    @Insert("insert into student3(id, name, address) values (#{id}+1,#{name},#{address})")
    int insertStudent(Student student);

    @Update("update student3 set name=#{name},address=#{address} where id=#{id}")
    int updateStudent(Student student);

    @Delete("delete from student3 where id=#{id}")
    int deleteStudent(String id);

    @Select("select * from student3 where name=#{param1} and address=#{param2}")
    List<Student> selectByParam(@Param("param1") String name, @Param("param2") String address);
}
