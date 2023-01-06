package com.bbk.classservice.controller;

import com.bbk.classservice.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public int getClassId(@PathVariable("studentId") int studentId) {
        return classService.getClassId(studentId);
    }
}
