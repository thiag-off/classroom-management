package com.api.classroom_management.course;

import com.api.classroom_management.student.Student;
import com.api.classroom_management.student.StudentService;
import com.api.classroom_management.tutor.Tutor;
import com.api.classroom_management.tutor.TutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TutorService tutorService;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(Long courseId) {
        return  courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException("COURSE WITH ID " + courseId +" DOES NOT EXISTS"));

    }
    @Transactional
    public void enrollStudent(Long courseId, Long studentId) {

        Course course = getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);

        if (course.getStudents().contains(student)) {
            throw new IllegalArgumentException("STUDENT IS ALREADY ENROLLED TO THIS COURSE");
        } else {
            course.getStudents().add(student);
        }
    }
    @Transactional
    public void assignTutor(Long courseId, Long tutorId) {

        Course course = getCourseById(courseId);
        Tutor tutor = tutorService.getTutorById(tutorId);

        if(course.getTutors().contains(tutor)){
            throw new IllegalStateException("TUTOR IS ALREADY ASSIGNED TO THIS COURSE");
        }else{
            course.getTutors().add(tutor);
        }

    }

    public void deleteCourse(Long courseId) {

       Boolean exists =  courseRepository.existsById(courseId);

       if(!exists){throw new IllegalStateException("COURSE WITH ID " + courseId + " DOES NOT EXISTS");}
       else{courseRepository.deleteById(courseId);}

    }

    public List<Course> getCourseByTutor(Long tutorId) {

       return courseRepository.findCourseByTutors_Id(tutorId)
               .orElseThrow( () -> new IllegalStateException("COURSE NOT FOUND"));
    }
}
