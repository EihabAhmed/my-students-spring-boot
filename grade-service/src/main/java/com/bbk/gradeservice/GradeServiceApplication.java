package com.bbk.gradeservice;

import com.bbk.gradeservice.model.Grade;
import com.bbk.gradeservice.repository.GradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GradeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(GradeRepository gradeRepository) {
//		return args -> {
//			Grade grade1 = new Grade();
//			grade1.setStudentId(1);
//			grade1.setStudentGrade(12);
//
//			Grade grade2 = new Grade();
//			grade2.setStudentId(2);
//			grade2.setStudentGrade(9);
//
//			gradeRepository.save(grade1);
//			gradeRepository.save(grade2);
//		};
//	}
}
