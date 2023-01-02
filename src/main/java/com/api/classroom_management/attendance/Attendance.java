package com.api.classroom_management.attendance;

import com.api.classroom_management.lecture.Lecture;
import com.api.classroom_management.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Attendance {


   @Id
   @SequenceGenerator(
           name = "attendance_sequence",
           sequenceName = "attendance_sequence",
           allocationSize = 1)
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "attendance_sequence")

   private Long Id;

   @ManyToOne
   private Lecture lecture;
   @ManyToOne
   private Student student;

   private Boolean isPresent;

   public Attendance(Lecture lecture, Student student, Boolean isPresent) {
      this.lecture = lecture;
      this.student = student;
      this.isPresent = isPresent;
   }
}
