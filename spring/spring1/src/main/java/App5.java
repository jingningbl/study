import com.pojo.LookUpTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bai
 * @version V1.0
 * @Package com
 * @date 2022/2/13 12:03
 * @describe
 */
public class App5 {
    public static void main(String[] args) {
//        LookUpTest lookUpTest = new LookUpTest();
//        lookUpTest.lunch();
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext10.xml");
        LookUpTest lookUpTest = context.getBean("lookUpTest", LookUpTest.class);
        lookUpTest.lunch();
    }
}
