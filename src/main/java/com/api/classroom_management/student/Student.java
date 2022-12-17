package com.api.classroom_management.student;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Student extends User {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;


}
