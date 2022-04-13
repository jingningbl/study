package com.ssm1.service.impl;

import com.ssm1.entity.Student;
import com.ssm1.dao.StudentDao;
import com.ssm1.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 11:52:27
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
//    @Override
//    public Student queryById(Integer id) {
//        return this.studentDao.queryById(id);
//    }
    @Override
    public Student selectById(Integer id) {
        return this.studentDao.selectById(id);
    }
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    @Override
//    public List<Student> queryAllByLimit(int offset, int limit) {
//        return this.studentDao.queryAllByLimit(offset, limit);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param student 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Student insert(Student student) {
//        this.studentDao.insert(student);
//        return student;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param student 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Student update(Student student) {
//        this.studentDao.update(student);
//        return this.queryById(student.getId());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(Integer id) {
//        return this.studentDao.deleteById(id) > 0;
//    }
}
