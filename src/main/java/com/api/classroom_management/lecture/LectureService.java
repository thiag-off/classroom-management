package com.api.classroom_management.lecture;

import com.api.classroom_management.attendance.Attendance;
import com.api.classroom_management.course.CourseService;
import com.api.classroom_management.student.Student;
import com.api.classroom_management.student.StudentService;
import com.api.classroom_management.tutor.TutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    private TutorService tutorService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public void addNewLecture(Lecture lecture, Long courseId, Long tutorId) {
        setLectureTutor(lecture, tutorId);
        setLectureCourse(lecture, courseId);
        courseService.assignTutor(courseId, tutorId);

        lectureRepository.save(lecture);
    }

    public Lecture getLectureById(Long lectureId) {

        return lectureRepository.findById(lectureId)
                        .orElseThrow(() -> new IllegalStateException("COURSE WITH ID " + lectureId +" DOES NOT EXISTS"));
    }

    @Transactional
    public void setLectureTutor(Lecture lecture, Long tutorId) {
        lecture.setTutor(tutorService.getTutorById(tutorId));
    }

    @Transactional
    public void setLectureCourse(Lecture lecture, Long courseId){
        lecture.setCourse(courseService.getCourseById(courseId));
    }

    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }

    @Transactional
    public void assignStudentToLecture(Long lectureId, Long studentId) {

        Lecture lecture = getLectureById(lectureId);
        Student student = studentService.getStudentById(studentId);

        lecture.getStudents().add(student);

    }

    public List<String> getAttendanceList(Long lectureId) {
        Lecture lecture = getLectureById(lectureId);
        List<Student> students = lecture.getStudents();
        ArrayList<String> studentsNames = new ArrayList<>();

        for(Student student : students){

            studentsNames.add(student.getFirstName());

        }

        return studentsNames;

    }
    @Transactional
    public void createLectureAttendance(Long lectureId, Long studentId, Boolean isPresent) {

        Lecture lecture  = getLectureById(lectureId);
        Student student = studentService.getStudentById(studentId);
        Attendance attendance = new Attendance(lecture, student, isPresent);

    }
}

