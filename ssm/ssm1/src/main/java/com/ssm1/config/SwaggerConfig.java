package com.ssm1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bai
 * @version V1.0
 * @Package com.ssm1.config
 * @date 2022/3/26 12:28
 * @describe 使用Swagger2快速生成接口文档
 * 建造者模式
 */
@Configuration
//必有,开启Swagger2的功能
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        //apiInfo封装基本自定义文档的信息
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //全部扫描
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.ssm1.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SSM整合项目")
                .version("v1.0")
                .termsOfServiceUrl("https://www.baidu.com")
                .build();
    }
}
