package com.api.classroom_management.tutor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/tutor")


    public class TutorController extends UserController {

    public TutorController(UserService userService) {
        super(userService);
    }


}
