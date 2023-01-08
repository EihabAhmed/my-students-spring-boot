package com.bbk.gradeservice.controller;

import com.bbk.gradeservice.dto.GradeResponse;
import com.bbk.gradeservice.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GradeResponse> getStudentGrades(@RequestParam List<Integer> studentIds) {
        return gradeService.getStudentGrades(studentIds);
    }
}
