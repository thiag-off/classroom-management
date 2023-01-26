package com.api.classroom_management.registration;

import com.api.classroom_management.role.RoleService;
import com.api.classroom_management.security.WebSecurityConfig;
import com.api.classroom_management.user.UserModel;

import com.api.classroom_management.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final WebSecurityConfig config;

    private final UserService userService;

    private final RoleService roleService;
    public RegistrationService(WebSecurityConfig config, UserService userService, RoleService roleService) {
        this.config = config;
        this.userService = userService;
        this.roleService = roleService;
    }

    public void register(UserModel user, Long roleId) {

        encodeUserPassword(user);
        assignRole(user, roleId);


        userService.signUpUser(user);

    }

    public void assignRole(UserModel user, Long roleId){
        user.setRoles(List.of(roleService.getRoleById(roleId)));

    }
    public void encodeUserPassword(UserModel user){

        user.setPassword(
                config
                        .passwordEncoder()
                        .encode(user.getPassword())
        );

    }
}
