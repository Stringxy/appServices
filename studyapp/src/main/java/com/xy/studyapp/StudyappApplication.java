package com.xy.studyapp;

import com.xy.studyapp.security.Appctx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyappApplication {

	public static void main(String[] args) {

		SpringApplication app=new SpringApplication(StudyappApplication.class);

		Appctx.ctx=app.run(args);
	}
}
