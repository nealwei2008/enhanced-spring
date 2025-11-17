package com.yoloho.enhanced.spring.xml;

import com.yoloho.enhanced.spring.support.CommonBeanPostProcessor;
import com.yoloho.enhanced.spring.support.CustomExceptionHandler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 默认WebMvc配置的spring-boot支持
 * 
 * @author jason
 *
 */
@EnableWebMvc
@Configuration
public class BaseWebMvcConfigurer implements WebMvcConfigurer {
    @Bean
    public CustomExceptionHandler customExceptionHandler() {
        // 载入异常捕获器
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        return customExceptionHandler;
    }
    
    @Bean
    public CommonBeanPostProcessor commonBeanPostProcessor() {
        // 载入通用参数处理器等
        return new CommonBeanPostProcessor();
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 启用默认静态资源处理
        configurer.enable();
    }
    
    @Bean
    @ConditionalOnClass(WebServerFactoryCustomizer.class)
    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return (factory) -> factory.setRegisterDefaultServlet(true);
    }
}
