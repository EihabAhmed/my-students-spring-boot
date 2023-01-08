package com.bbk.studentservice.controller;

import com.bbk.studentservice.dto.StudentRequest;
import com.bbk.studentservice.model.Student;
import com.bbk.studentservice.model.Students;
import com.bbk.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Students getAllStudents() {
        Students students = new Students();
        students.setStudents(studentService.getAllStudents());
        return students;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }
}
