package com.example.javaknowledge2.demos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/"); // JSP文件的前缀路径 /WEB-INF/jsp/目录是相对于你的类路径（通常是src/main/webapp/WEB-INF/jsp/）
        resolver.setSuffix(".jsp"); // JSP文件的后缀
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class); // 如果你使用JSTL
        // 可以设置更多属性，如characterEncoding等
        return resolver;
    }

    // 你可以在这里添加其他配置，如添加视图控制器、拦截器等
    // 例如，添加一个视图控制器来映射"/"到"index"视图
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    // ... 其他WebMvcConfigurer接口的方法（如果需要的话）
}