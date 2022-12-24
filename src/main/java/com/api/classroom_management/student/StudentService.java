package com.api.classroom_management.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();

    }

    public Student getStudentById(Long studentId) {
        return  studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("COURSE WITH ID " + studentId +" DOES NOT EXISTS"));
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
