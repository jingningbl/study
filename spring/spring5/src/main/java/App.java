import com.spring.dao.StudentDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/22 9:50
 * @describe
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        StudentDao bean = context.getBean(StudentDao.class);
        bean.selectById(1);
    }
}
