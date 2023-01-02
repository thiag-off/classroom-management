package com.api.classroom_management.attendance;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;


    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }


    @PostMapping
    public void createLectureAttendance(
            @RequestParam("lectureId") Long lectureId,
            @RequestParam("studentId") Long studentId,
            @RequestParam("isPresent") Boolean isPresent){

        attendanceService.createLectureAttendance(lectureId, studentId, isPresent);

    }

}
