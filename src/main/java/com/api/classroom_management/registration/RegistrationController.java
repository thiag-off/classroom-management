package com.api.classroom_management.registration;


import com.api.classroom_management.user.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody UserModel user){
        return registrationService.register(user);

    }

}
