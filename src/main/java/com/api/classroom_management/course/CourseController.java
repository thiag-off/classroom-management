package com.api.classroom_management.course;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){

        return List.of(new Course("Arquitetura"), new Course("Análise e Desenvolvimento de Sistemas"));
    }

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
    }
}


