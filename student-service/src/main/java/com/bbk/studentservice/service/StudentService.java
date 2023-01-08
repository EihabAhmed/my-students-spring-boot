package com.bbk.studentservice.service;

import com.bbk.studentservice.dto.GradeResponse;
import com.bbk.studentservice.dto.StudentRequest;
import com.bbk.studentservice.model.Student;
import com.bbk.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;
    private final WebClient.Builder webClientBuilder;

    public Student addStudent(StudentRequest studentRequest) {

        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());

        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        List<Long> studentIds = students.stream()
                .map(Student::getId)
                .toList();

        GradeResponse[] gradeResponseArray = webClientBuilder.build().get()
                .uri("http://grade-service/api/grade",
                        uriBuilder -> uriBuilder.queryParam("studentIds", studentIds).build())
                .retrieve()
                .bodyToMono(GradeResponse[].class)
                .block();

        if (gradeResponseArray != null) {
            for (GradeResponse gradeResponse : gradeResponseArray) {
                for (Student student : students) {
                    if (student.getId() == gradeResponse.getStudentId()) {
                        student.setGrade(gradeResponse.getStudentGrade());
                    }
                }
            }
        }

        for (Student student : students) {
            if (student.getGrade() == null) {
                student.setGrade(0);
            }
        }

        return students;
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id " + id + " is not found!"));
        studentRepository.delete(student);
    }
}
