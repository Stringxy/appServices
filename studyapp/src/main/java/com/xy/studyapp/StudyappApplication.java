package com.xy.studyapp;

import com.xy.studyapp.security.Appctx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class StudyappApplication  extends SpringBootServletInitializer implements WebApplicationInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(StudyappApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication app=new SpringApplication(StudyappApplication.class);

		Appctx.ctx=app.run(args);
	}
}
