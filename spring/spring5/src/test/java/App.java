import com.spring.dao.StudentDao;
import com.spring.pojo.Student;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/22 10:27
 * @describe 测试spring中方法的配置
 */
//以什么样的环境运行测试类
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration指明初始化容器所需要的配置文件或者配置类的位置
@ContextConfiguration(locations = "classpath:application.xml")
public class App {
    @Autowired
    private StudentDao studentDao;

    //    在测试类执行前执行一次,且必须是static修饰
    @BeforeClass
    public static void beforeClass() {

    }

    //    在每个测试方法执行前执行一次
    @Before
    public void before() {
        System.out.println("Before");
    }

    @Test
    public void testSay() {
        System.out.println("哈哈");
    }

    @Test
    public void testQueryById() {
        studentDao.selectById(1);
    }

    @Test
    public void testBatchInsert() {
        Student student = null;
        List<Student> param = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            student = new Student();
            student.setId(i + 2);
            student.setName("小白" + i);
            student.setAddress("甘肃庆阳" + i);
            param.add(student);
        }
        studentDao.batchInsert(param);
    }
}
