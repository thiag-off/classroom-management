package com.api.classroom_management.registration;

import com.api.classroom_management.security.WebSecurityConfig;
import com.api.classroom_management.user.UserModel;

import com.api.classroom_management.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final WebSecurityConfig config;

    private final UserService userService;
    public RegistrationService(WebSecurityConfig config, UserService userService) {
        this.config = config;
        this.userService = userService;
    }

    public String register(UserModel user) {
        user.setPassword(
                config
                        .passwordEncoder()
                        .encode(user.getPassword())
        );


        return userService.signUpUser(user);

    }
}
