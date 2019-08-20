package com.project.taste.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * @Description:
     * 对文件的路径进行配置, 创建一个虚拟路径/Path/**
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //Windows下
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:/C:/taste/file/");
    }
}
