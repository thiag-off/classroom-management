package com.api.classroom_management.student;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
public class Student extends User {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Course> courses;

    public Student(String firstName, String lastName, String email, LocalDate birthDate, Integer age) {
        super(firstName, lastName, email, birthDate, age);
    }
}
