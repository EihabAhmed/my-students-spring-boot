package com.bbk.studentservice.controller;

import com.bbk.studentservice.dto.StudentRequest;
import com.bbk.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addStudent(@RequestBody StudentRequest studentRequest) {
        studentService.addStudent(studentRequest);
        return "Student added successfully";
    }
}
