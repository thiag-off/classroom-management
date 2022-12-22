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

    @GetMapping(path = "{lectureId}")
    public Lecture getLectureById(@PathVariable("lectureId") Long lectureId){
        return lectureService.getLectureById(lectureId);
    }

}
