import com.pojo.Female;
import com.pojo.Male;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author bai
 * @version V1.0
 * @Package com.util
 * @date 2022/2/15 21:16
 * @describe
 */
@Configuration
//{}中写多个
@ComponentScan("com")
public class MyConfiguration {
    /**
     * 方法名代表id,返回类型代表class
     * @return
     */
    @Bean
    public Male lulu(){
        Male male = new Male();
        male.setName("陆陆");
        male.setFemale(yuanyuan());
        return male;
    }
    @Bean
    public Female yuanyuan(){
        Female female = new Female();
        female.setName("媛媛");
        return female;
    }
}
