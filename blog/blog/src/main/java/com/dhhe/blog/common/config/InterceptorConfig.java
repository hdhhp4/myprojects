package com.dhhe.blog.common.config;

import com.dhhe.blog.common.interceptor.AuthTokenInterceptor;
import com.dhhe.blog.common.interceptor.SystemInitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor systemInitInterceptor() {
        return new SystemInitInterceptor();
    }

    @Bean
    public HandlerInterceptor authTokenInterceptor() {
        return new AuthTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(systemInitInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(authTokenInterceptor()).addPathPatterns("/**").excludePathPatterns(Config.exclusions);
    }
}
