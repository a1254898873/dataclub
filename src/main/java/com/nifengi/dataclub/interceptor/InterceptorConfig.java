package com.nifengi.dataclub.interceptor;

import com.nifengi.dataclub.interceptor.checkCookie;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new checkCookie()).addPathPatterns("/**").excludePathPatterns("/index","/login","/register","/user");

    }
}