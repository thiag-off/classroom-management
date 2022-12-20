package com.api.classroom_management.user;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class User {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Integer age;

    public User(String firstName, String lastName, String email, LocalDate birthDate, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
    }
}
