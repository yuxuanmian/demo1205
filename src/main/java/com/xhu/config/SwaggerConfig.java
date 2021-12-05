package com.xhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)//是否启用swagger
                .groupName("余轩冕")
                //basePackage：指定要扫描的包
                //any：扫描全部
                //none：都不扫描\
                //withClassAbbitation：扫描类上的注解，参数是一个注解的反射对象
                //withMethodAbbitation：扫描方法上的注解
                .select().apis(RequestHandlerSelectors.basePackage("com.xhu.controller"))
                //path（）过滤什么路径
                //.paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("服务:发布为daocke镜像,权限管理，用户管理，页面管理，日志 后台 APIs")
                .description("服务:发布为daocke镜像,权限管理，用户管理，页面管理，日志 后台")
                .termsOfServiceUrl("http://192.168.1.198:10070/platformgroup/ms-admin")
                .version("1.0")
                .build();
    }
}
