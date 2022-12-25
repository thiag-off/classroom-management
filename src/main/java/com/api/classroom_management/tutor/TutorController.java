package com.api.classroom_management.tutor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tutor")
public class TutorController {

    private final TutorService tutorService;


    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public List<Tutor> getAllTutors(){
        return tutorService.getAllTutors();
    }

    @GetMapping(path = "{tutorId}")
    public Tutor getTutorById(@PathVariable("tutorId") Long tutorId){
        return tutorService.getTutorById(tutorId);
    }

    @DeleteMapping(path = {"tutorId"})
    public void deleteTutor(@PathVariable("tutorId") Long tutorId) {
        tutorService.deleteTutor(tutorId);
    }
}

