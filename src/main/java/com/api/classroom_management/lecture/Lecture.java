package com.api.classroom_management.lecture;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.student.Student;
import com.api.classroom_management.tutor.Tutor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Lecture {

    @Id
    @SequenceGenerator(
            name = "lecture_sequence",
            sequenceName = "lecture_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lecture_sequence")
    private Long id;
    private String subject;
    @ManyToOne
    @JoinColumn
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutor;

    @ManyToMany
    @JoinTable
    private List<Student> students;


    public Lecture( Course course, String subject) {

        this.course = course;
        this.subject = subject;
    }
}
