package com.spring.dao;

import com.spring.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package com.spring.dao
 * @date 2022/2/22 10:06
 * @describe
 */
@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    private DataSourceTransactionManager transactionManager;

    public void selectById(Integer id) {
        String sql = "select * from student where id=?";
        Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(student);
    }
//声明式事务
    @Transactional
    public void batchInsert(List<Student> studentList) {
        String sql = "insert into student(id, name, address) values (?,?,?)";
//        创建默认的事务对象
//        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
//        开启事务
//        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            for (int i = 0; i < studentList.size(); i++) {
                if (i == 2) {
                    throw new RuntimeException("无中生有");
                }
                Student currentParam = studentList.get(i);
                jdbcTemplate.update(sql, currentParam.getId(), currentParam.getName(), currentParam.getAddress());
            }
//            提交事务
//            transactionManager.commit(status);
        } catch (Exception e) {
            throw e;
//       回滚事务
//            transactionManager.rollback(status);
        }
    }
}
