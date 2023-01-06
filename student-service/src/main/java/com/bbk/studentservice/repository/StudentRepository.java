package com.bbk.studentservice.repository;

import com.bbk.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
