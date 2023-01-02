package com.api.classroom_management.attendance;

import com.api.classroom_management.lecture.Lecture;
import com.api.classroom_management.lecture.LectureService;
import com.api.classroom_management.student.Student;
import com.api.classroom_management.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {


    private final AttendanceRepository attendanceRepository;
    @Autowired
    private LectureService lectureService;

    @Autowired
    private StudentService studentService;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public void createLectureAttendance(Long lectureId, Long studentId, Boolean isPresent) {
        Lecture lecture  = lectureService.getLectureById(lectureId);
        Student student = studentService.getStudentById(studentId);
        attendanceRepository.save(new Attendance(lecture, student, isPresent));
    }
}
