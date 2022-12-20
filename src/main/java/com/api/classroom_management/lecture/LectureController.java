package com.api.classroom_management.lecture;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/lecture")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<Lecture> getAllLectures(){
        return lectureService.getAllLectures();
    }

    @PostMapping
    public void createNewLecture(@RequestBody Lecture lecture){


    }
}
