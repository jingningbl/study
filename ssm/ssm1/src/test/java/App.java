import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dao.EmployeeDao;
import com.ssm1.dao.StudentDao;
import com.ssm1.dto.responseDto.EmployeeDto;
import com.ssm1.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/3/26 11:57
 * @describe
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
@WebAppConfiguration
public class App {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmployeeDao employeeDao;

    //    @Test
//    public void testDao() {
//        System.out.println(studentDao.queryById(2));
//    }
    @Test
    public void testMP() {
//        System.out.println(studentDao.selectById(2));
//        Student student = new Student();
//        student.setId(1);
//        student.setName("诸葛");
//        student.setAge(18);
//        student.setClassId(1);
//        studentDao.insert(student);

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("name", "小");
//        List<Student> students = studentDao.selectList(wrapper);
//        System.out.println(students);

        Page<Student> page = new Page<>(1, 2);
//        Page<Student> studentPage = studentDao.selectPage(page, wrapper);
//        System.out.println(studentPage.getRecords());
        Page<Student> studentPage = studentDao.queryMyPage(page, wrapper);
        System.out.println(studentPage.getRecords());
    }

    @Test
    public void testGetEmInfoByUsernameAndPassword(){
        EmployeeDto employeeDto = employeeDao.getEmInfoByUsernameAndPassword("123456789", "1513");
        System.out.println(employeeDto);
    }
}
