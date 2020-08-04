package com.hbsi.swagger.config;

import com.hbsi.swagger.controller.HelloController;
import org.omg.CORBA.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author lbq
 * @date 2020 08  16:15
 */
@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    //配置swagger的Docket的bean实例
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }@Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    @Bean
    public Docket docket(){
        //Environment environment
        //获取项目的环境：
        // 设置要显示swagger的环境
//        Profiles profiles = Profiles.of("dev","test");

        // 判断当前环境是否处于指定的环境列表中
//        boolean flag  = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("路在何方")

                //enable()是否启动swagger  true false
                .enable(true)
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //指定要扫描的包
                //any()扫描全部
                //none()  不扫描
                //withClassAnnotation()扫描类上的注解  注解是一个反射的对象
                //withMethodAnnotation  扫描方法上的注解
                //bastPackage()一般用法
                .apis(RequestHandlerSelectors.basePackage("com.hbsi.swagger.controller"))
                //过滤请求
               // .paths(PathSelectors.ant("/hbsi/**"))
                .build();
    }
 //配置Swagger信息的apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("路在何方", "https://blog.csdn.net/lbqlzch", "44444@qq.com");
        return new ApiInfo("路在何方API",
                "脚踏实地",
                "1.0",
                "https://blog.csdn.net/lbqlzch",
                contact ,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
