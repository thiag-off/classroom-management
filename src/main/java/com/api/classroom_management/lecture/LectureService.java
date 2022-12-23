package com.api.classroom_management.lecture;

import com.api.classroom_management.course.CourseService;
import com.api.classroom_management.tutor.TutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    private TutorService tutorService;
    @Autowired
    private CourseService courseService;
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
}
