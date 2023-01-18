package com.api.classroom_management.user;

import com.api.classroom_management.role.RoleModel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class UserModel implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence" , sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long Id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Integer age;

    @ManyToMany
    @JoinTable
    private List<RoleModel> roles;


    public UserModel( String firstName, String lastName, String email, String password, LocalDate birthDate, Integer age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
