package com.lancefallon.springstarter.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import com.lancefallon.springstarter.SpringBootStarterDemoApplication;

@Configuration
public class WebInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SpringBootStarterDemoApplication.class);
	}
	
}
