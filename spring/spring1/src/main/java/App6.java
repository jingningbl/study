import com.pojo.Man;
import com.pojo.Woman;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/2/13 13:07
 * @describe
 */
public class App6 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext11.xml");
        Woman yuanyuan = (Woman) context.getBean("yuanyuan");
        System.out.println(yuanyuan);
        Man lulu = (Man) context.getBean("lulu");
        System.out.println(lulu);
    }
}
