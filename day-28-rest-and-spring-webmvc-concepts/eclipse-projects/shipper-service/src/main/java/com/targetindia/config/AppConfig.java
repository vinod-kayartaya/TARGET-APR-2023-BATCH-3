package com.targetindia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.targetindia.controllers"})
public class AppConfig implements WebApplicationInitializer {
	
	

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("creating a spring container...");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		
		System.out.println("creating and registering the dispatcher servlet...");
		DispatcherServlet ds = new DispatcherServlet(ctx);
		Dynamic s1 = servletContext.addServlet("ds", ds);
		s1.addMapping("/"); // handle all requests for this application
		s1.setLoadOnStartup(0);
		
	}

}
