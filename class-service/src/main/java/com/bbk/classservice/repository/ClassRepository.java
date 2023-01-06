package com.bbk.classservice.repository;

import com.bbk.classservice.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findByStudentId(int studentId);
}