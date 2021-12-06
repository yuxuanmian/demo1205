package com.xhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class InterceptorCofig implements WebMvcConfigurer {

    List<String> excluetList=new ArrayList<>(Arrays.asList("/assets/**","/js/**","/login.html","/login"));

    private final HandlerInterceptor interceptor;

    @Autowired
    public InterceptorCofig(HandlerInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excluetList);
    }
}
