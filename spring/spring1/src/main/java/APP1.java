import com.pojo.Woman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/4 13:28
 * @describe
 */
public class APP1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext4.xml");
        Woman yuanyuan = (Woman) context.getBean("yuanyuan");
        System.out.println(yuanyuan);
    }
}
