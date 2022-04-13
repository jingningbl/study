package com.pojo;

import org.springframework.stereotype.Component;

/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/14 11:55
 * @describe
 */
//组件的注解,是通用注解,在扫描过程中,将包含该注解的Class交给IOC容器管理
//    @Controller:servlet控制层
//    @Service:service业务层
//    @Repository:dao数据库
//    @Configuration:特殊,java配置类
@Component("haha")
public class MyComponent {
}
