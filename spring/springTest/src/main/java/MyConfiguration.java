import com.dao.Cat;
import com.dao.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author bai
 * @version V1.0
 * @Package com.util
 * @date 2022/2/15 22:12
 * @describe
 */
@Configuration
@ComponentScan("com")
public class MyConfiguration {
    @Bean
    @Scope("prototype")
    public Cat bai() {
        Cat cat = new Cat();
        cat.setName("小白");
        return cat;
    }

    @Bean
    public Dog hei() {
        Dog dog = new Dog();
        dog.setName("小黑");
        return dog;
    }
}
