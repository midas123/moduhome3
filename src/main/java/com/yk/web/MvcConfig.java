package com.yk.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	private final long MAX_AGE_SECS = 3600;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	String in_path = "classpath:/static/"; //프로젝트 내부
    	String ex_path = "file:///C:/Users/yk1/Desktop/upload/images/"; //외부
       registry
               .addResourceHandler("/**", "/images/**").addResourceLocations(in_path, ex_path);
               //.setCachePeriod(3600)
              // .resourceChain(true)
              // .addResolver(new PathResourceResolver());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }

} 