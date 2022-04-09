package com.springboot1.service;

import com.springboot1.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @date 2022/3/31 19:33
 * @describe
 */
@Service
@Slf4j
public class StudentService {

//    static Logger logger = LoggerFactory.getLogger(Springboot1Application.class);

    public List<Student> selectList() {
        //使用@Slf4j注解
//        log.error("error1");
//        log.warn("warn1");
//        log.info("info1");
//        log.debug("debug1");
//        log.trace("trace1");
//        logger.error("error1");
//        logger.warn("warn1");
//        logger.info("info1");
//        logger.debug("debug1");
//        logger.trace("trace1");
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("木子" + i);
            studentList.add(student);
        }
        return studentList;
    }
}
