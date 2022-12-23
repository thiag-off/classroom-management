package com.api.classroom_management.tutor;

import com.api.classroom_management.course.Course;
import com.api.classroom_management.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
