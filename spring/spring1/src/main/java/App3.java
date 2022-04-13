import com.pojo.Woman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/4 14:40
 * @describe
 */
public class App3 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext7.xml");
//        获取容器中所有bean的名字
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName:beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }
        System.out.println("====================打印beanName完毕===================");
        Woman woman = (Woman) context.getBean("yuanyuan");
        System.out.println(woman);
    }
}
