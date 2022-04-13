package com.service;

import com.dao.PeopleDao;
import com.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author bai
 * @version V1.0
 * @Package com.service
 * @date 2022/2/15 11:47
 * @describe
 */
@Service
//该注解设置单例或者多例,设置后不能够调用自定义销毁方法
//@Scope("prototype")
public class StudentService {
    /**
     * 通过注解放在成员变量上面的注入,既不是有参构造注入,也不是setter注入,而是通过反射机制
     * 破坏封装性,直接赋值的注入(Field.set()),如果非要使用有参构造注入或者setter注入,则可以把该注解放在构造方法上或者setter方法上
     */
//    按照类型或者名称匹配
//    @Autowired
////    在类型匹配之上在进行名字匹配(不可单独使用)
//    @Qualifier("studentDao")
//    private PeopleDao peopleDao;
//
//    public void queryPeople() {
//        peopleDao.queryById(1);
//    }
//    @Autowired
//    private PeopleDao teacherDao;
//
//    public void queryPeople() {
//        teacherDao.queryById(1);
//    }
//    该注解相当于@Autowired和@Qualifier一起使用
//    @Resource(name = "teacherDao")
    @Autowired
    private PeopleDao peopleDao;

    public void queryPeople() {
        peopleDao.queryById(1);
    }

    //    public PeopleDao getPeopleDao() {
//        return peopleDao;
//    }
//    @Autowired
//
//    public void setPeopleDao(PeopleDao peopleDao) {
//        System.out.println("peopleDao");
//        this.peopleDao = peopleDao;
//    }
    @PostConstruct
    public void myInit() {
        System.out.println("自定义初始化方法");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("自定义销毁的方法");
    }
}
