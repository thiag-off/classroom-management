package com.api.classroom_management.registration;


import com.api.classroom_management.user.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserModel user,
                         @RequestParam Long roleId){
        registrationService.register(user, roleId);

    }

}
