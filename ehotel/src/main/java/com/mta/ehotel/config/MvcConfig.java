package com.mta.ehotel.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/resources/vendor/**").addResourceLocations("classpath:/static/vendor/");
		registry.addResourceHandler("/resources/font/**").addResourceLocations("classpath:/static/font/");
		registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/resources/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/resources/libs/**").addResourceLocations("classpath:/static/libs/");
		registry.addResourceHandler("/resources/img/**").addResourceLocations("classpath:/static/img/");
		
		
		Path avatarUploadDir = Paths.get("./Upload/Avatar");
		String avatarUploadPath= avatarUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/Upload/Avatar/**").addResourceLocations("file:/"+avatarUploadPath+"/");
	
	}
}
