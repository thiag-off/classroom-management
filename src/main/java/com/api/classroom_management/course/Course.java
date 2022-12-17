package com.api.classroom_management.course;

import com.api.classroom_management.lecture.Lecture;
import com.api.classroom_management.student.Student;
import com.api.classroom_management.tutor.Tutor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    private String title;

    public Course(String title) {
        this.title = title;
    }

    @OneToMany( mappedBy = "course", fetch = FetchType.LAZY)
    private List<Lecture> lectures;

    @ManyToMany
    @JoinTable
    private List<Tutor> tutors;


    @ManyToMany
    @JoinTable
    private List<Student> students;
}
