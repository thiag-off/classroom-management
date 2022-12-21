package com.api.classroom_management.lecture;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public void addNewLecture(Lecture lecture) {

    }

    public Lecture getLectureById(Long lectureId) {

        return lectureRepository.findById(lectureId)
                        .orElseThrow(() -> new IllegalStateException("COURSE WITH ID " + lectureId +" DOES NOT EXISTS"));
    }
}
