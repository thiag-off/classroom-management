package com.api.classroom_management.security;

import com.api.classroom_management.role.RoleModel;
import com.api.classroom_management.role.RoleName;
import com.api.classroom_management.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

            http
                    .httpBasic()
                    .and()
                    .authorizeHttpRequests(auth -> auth

                            .requestMatchers("/api/v*/registration/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/v*/tutor").hasRole("ADMIN")
                            .anyRequest()
                            .authenticated()
                    )

                    .formLogin()
                    .and()
                    .csrf().disable();

            return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository){
        return args -> {
            RoleModel role = new RoleModel(RoleName.ROLE_ADMIN);
            RoleModel role1 = new RoleModel(RoleName.ROLE_STUDENT);
            RoleModel role2 = new  RoleModel(RoleName.ROLE_TUTOR);

        roleRepository.saveAll(List.of(role,role1,role2));
        };
    }

}
