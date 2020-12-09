package com.example.demo.util;

import com.example.demo.entity.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 资源映射路径
         * addResourceHandler：访问映射路径
         * addResourceLocations：资源绝对路径
         */

        String basename = this.applicationProperties.getMasterStore().getPath().trim();
        basename = basename.replace("\\", "/");
        basename = basename.replace("//", "/");
        if (!basename.endsWith("/")) {
            basename = basename + "/";
        }
        registry.addResourceHandler("/**").addResourceLocations("file:"+basename);
    }

}
