package com.bbk.studentservice.service;

import com.bbk.studentservice.dto.StudentRequest;
import com.bbk.studentservice.model.Student;
import com.bbk.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public void addStudent(StudentRequest studentRequest) {

        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());

        studentRepository.save(student);
    }

}
