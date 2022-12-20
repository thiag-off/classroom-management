package com.api.classroom_management.course;

import com.api.classroom_management.student.Student;
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

       return courseService.getAllCourses();
    }

    @GetMapping(path = "{courseId}")
    public Course getCourse(@PathVariable("courseId") Long courseId ){
        return  courseService.getCourseById(courseId);
    }

    @PostMapping(path = "{courseId}")
    public void enrollStudent(@PathVariable("courseId") Long courseId,
                              @RequestParam Long studentId){

        courseService.enrollStudent(courseId, studentId);
    }

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
    }


}


