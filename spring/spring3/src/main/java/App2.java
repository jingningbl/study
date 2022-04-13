import com.service.StudentService;
import com.util.DataSourceConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/14 11:13
 * @describe
 */
public class App2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//        StudentService studentService = context.getBean("studentService", StudentService.class);
//        studentService.queryPeople();
//        StudentService studentService1 = context.getBean("studentService", StudentService.class);
//        StudentService studentService2 = context.getBean("studentService", StudentService.class);
//        System.out.println(studentService1==studentService2);
//        context.registerShutdownHook();
        DataSourceConfig bean = context.getBean("dataSourceConfig", DataSourceConfig.class);
        System.out.println(bean);
    }
}
