import com.pojo.Female;
import com.pojo.Male;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/14 11:13
 * @describe
 */
public class App3 {
    public static void main(String[] args) {
//        通过java配置类加载Bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        Male lulu = context.getBean(Male.class);
        Female yuanyuan = context.getBean("yuanyuan", Female.class);
        System.out.println(lulu.getFemale()==yuanyuan);
    }
}
