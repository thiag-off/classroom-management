package com.api.classroom_management.lecture;

import com.api.classroom_management.attendance.Attendance;
import com.api.classroom_management.course.Course;
import com.api.classroom_management.student.Student;
import com.api.classroom_management.tutor.Tutor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    //@JsonIgnore
    private Course course;

    @ManyToOne
    private Tutor tutor;

    @ManyToMany
    @JoinTable
    private List<Student> students;

    @OneToMany(mappedBy = "lecture")
    private List<Attendance> attendanceList;


    public Lecture( Course course, Tutor tutor ,String subject) {

        this.tutor = tutor;
        this.course = course;
        this.subject = subject;
    }

    public Lecture(String subject){
        this.subject = subject;
    }
}
