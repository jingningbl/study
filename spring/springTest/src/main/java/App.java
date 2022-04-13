import com.dao.Cat;
import com.dao.Dog;
import com.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package com
 * @date 2022/2/15 22:19
 * @describe
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Cat bai = context.getBean("bai", Cat.class);
        Dog hei = context.getBean("hei", Dog.class);
        System.out.println(bai);
        bai.say();
        System.out.println(hei);
        hei.say();
        TestService testService = context.getBean("testService", TestService.class);
        System.out.println(testService);
//        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
    }
}
