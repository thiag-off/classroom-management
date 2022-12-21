package com.api.classroom_management.tutor;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.user.User;
import jakarta.persistence.*;
import lombok.Data;
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
public class Tutor extends User {
    @Id
    @SequenceGenerator(name = "tutor_sequence" , sequenceName = "tutor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutor_sequence")
    private Long id;


    @ManyToMany(mappedBy = "tutors")
    private List<Course> courses;

    public Tutor(String firstName, String lastName, String email, LocalDate birthDate, Integer age) {
        super(firstName, lastName, email, birthDate, age);
    }
}
