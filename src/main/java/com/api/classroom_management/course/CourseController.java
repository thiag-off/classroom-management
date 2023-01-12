package com.api.classroom_management.course;

import com.api.classroom_management.student.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
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
    public Course getCourseById(@PathVariable("courseId") Long courseId ){
        return  courseService.getCourseById(courseId);
    }

    @GetMapping(path = "getTutor/{tutorId}")
    public List<Course> getCourseByTutor(@PathVariable("tutorId") Long tutorId){
        return courseService.getCourseByTutor(tutorId);
    }

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
    }

    @PostMapping(path = "{courseId}/enrollStudent/{studentId}")
    public void enrollStudent(@PathVariable("courseId") Long courseId,
                              @PathVariable("studentId") Long studentId){

        courseService.enrollStudent(courseId, studentId);
    }

    @PostMapping(path = "{courseId}/assignTutor/{tutorId}")
    public void assignTutor(@PathVariable("courseId") Long courseId,
                            @PathVariable("tutorId")Long tutorId){
        courseService.assignTutor(courseId, tutorId);
    }

    @DeleteMapping(path = "courseId")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.deleteCourse(courseId);
    }




}


