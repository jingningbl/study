import com.spring6.entity.Student;
import com.spring6.entity.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @date 2022/4/1 8:39
 * @describe
 */
public class SpringTest {
    @Test
    public void testStudy() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student) context.getBean("student");
        Teacher teacher = (Teacher) context.getBean("teacher");
        student.study();
        teacher.teach();
    }
}
