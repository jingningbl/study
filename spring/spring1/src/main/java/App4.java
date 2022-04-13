import com.pojo.FierceMan;
import com.pojo.Man;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/5 10:43
 * @describe
 */
public class App4 {
    /**
     * 循环依赖
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext9.xml");
        Man hao = context.getBean("hao", Man.class);
        System.out.println(hao);
        System.out.println("==================================");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("===================================");
        FierceMan fierceMan = context.getBean("fierceMan", FierceMan.class);
        System.out.println(fierceMan);
    }
}
