package com.api.classroom_management.student;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.lecture.Lecture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Student{

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
           allocationSize = 1)
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "student_sequence")

    private Long id;


    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Integer age;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Course> courses;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Lecture> lectures;

    public Student(String firstName, String lastName, String email, LocalDate birthDate, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
    }
}
