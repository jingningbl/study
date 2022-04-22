import com.spring9.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: bai
 * @date: 2022/4/22 9:07
 * @description:
 */
public class TestAop {

    @Test
    public void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.select();
    }
}
