package com.bbk.gradeservice.service;

import com.bbk.gradeservice.dto.GradeResponse;
import com.bbk.gradeservice.model.Grade;
import com.bbk.gradeservice.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    @Transactional(readOnly = true)
    public List<GradeResponse> getStudentGrades(List<Integer> studentIds) {

        return gradeRepository.findByStudentIdIn(studentIds).stream()
                .map(grade ->
                        GradeResponse.builder()
                                .studentId(grade.getStudentId())
                                .studentGrade(grade.getStudentGrade())
                                .build()
                ).toList();
    }
}
