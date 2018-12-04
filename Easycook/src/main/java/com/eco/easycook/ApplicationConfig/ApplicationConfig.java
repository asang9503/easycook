package com.eco.easycook.ApplicationConfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Nvarchar
 */
@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

    //设置虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/infoimg/**").addResourceLocations("file:D:/upload/infoimg/");

    }
}
