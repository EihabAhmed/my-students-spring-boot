package com.bbk.gradeservice.repository;

import com.bbk.gradeservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentIdIn(List<Integer> studentIds);
}
