package com.api.classroom_management;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.course.CourseRepository;
import com.api.classroom_management.lecture.Lecture;
import com.api.classroom_management.lecture.LectureRepository;
import com.api.classroom_management.student.Student;
import com.api.classroom_management.student.StudentRepository;
import com.api.classroom_management.tutor.Tutor;
import com.api.classroom_management.tutor.TutorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;


import static java.util.Calendar.*;


public class config {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        TutorRepository tutorRepository,
                                        CourseRepository courseRepository,
                                        LectureRepository lectureRepository) {
        return args -> {
            Student student = new Student(
                    "Thiago",
                    "Fortunato",
                    "thiago@student.com",
                    LocalDate.of(2000, OCTOBER, 04),
                    22, roleName);
            Student student2 = new Student(
                    "Carol",
                    "Pereira",
                    "carol@student.com",
                    LocalDate.of(2000, OCTOBER, 04),
                    22, roleName);
            Tutor tutor = new Tutor("Jorge",
                    "Furtado",
                    "jorge@furtado.com",
                    LocalDate.of(1980, MARCH,27),
                    42);

            Course course = new Course("Análise e Desenvolvimento de Sistemas",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

            Lecture lecture = new Lecture(course, tutor,"Introducao" );

            studentRepository.saveAll(List.of(student, student2));
            tutorRepository.save(tutor);
            courseRepository.save(course);
            lectureRepository.save(lecture);

        };
    }

}
