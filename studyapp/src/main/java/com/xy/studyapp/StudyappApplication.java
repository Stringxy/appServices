package com.xy.studyapp;

import com.xy.studyapp.fliter.ControllFilter;
import com.xy.studyapp.security.Appctx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;


@EnableTransactionManagement
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

	@Bean
	public FilterRegistrationBean testFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new ControllFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("controllFilter");
		registration.setOrder(1);
		return registration;
	}
}
