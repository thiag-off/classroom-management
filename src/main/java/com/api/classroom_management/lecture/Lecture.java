package com.api.classroom_management.lecture;

import com.api.classroom_management.course.Course;
import jakarta.persistence.*;

@Entity
@Table
public class Lecture {

    @SequenceGenerator(name = "lecture_sequence", sequenceName = "lecture_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_sequence")
    @Id
    private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   private Course course;

   private String subject;

}
