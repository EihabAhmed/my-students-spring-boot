package com.bbk.classservice.service;

import com.bbk.classservice.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;

    @Transactional(readOnly = true)
    public int getClassId(int studentId) {
        if (classRepository.findByStudentId(studentId).isPresent()) {
            return classRepository.findByStudentId(studentId).get().getClassId();
        } else {
            return -1;
        }
    }
}
