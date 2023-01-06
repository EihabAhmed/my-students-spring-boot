package com.bbk.classservice;

import com.bbk.classservice.model.Class;
import com.bbk.classservice.repository.ClassRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClassServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ClassRepository classRepository) {
		return args -> {
			Class class1 = new Class();
			class1.setStudentId(1);
			class1.setClassId(12);

			Class class2 = new Class();
			class2.setStudentId(2);
			class2.setClassId(9);

			classRepository.save(class1);
			classRepository.save(class2);
		};
	}
}
