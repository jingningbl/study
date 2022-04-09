import com.alibaba.fastjson.JSON;
import com.pojo.City;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2022/1/2 9:25
 * @describe
 */
public class CityTest {
    City city1=new City("wuhan","武汉");
    City city2=new City("sh","上海");
@Test
    public void testCity(){
    String str1= JSON.toJSONString(city1);
    System.out.println(str1);
    String str2=JSON.toJSONString(true);
    System.out.println(str2);
    City[] cts={city1,city2};
    String str3=JSON.toJSONString(cts);
    System.out.println(str3);
    List<City> list=new ArrayList<>();
    list.add(city1);
    list.add(city2);
    String str4=JSON.toJSONString(list);
    System.out.println(str4);
    String str5="{\"cityName\":\"wuhan\",\"cityValue\":\"武汉\"}";
    City city3=JSON.parseObject(str5,City.class);
    System.out.println(city3);
    }
}
