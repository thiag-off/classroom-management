package com.api.classroom_management.tutor;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TutorService {


    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor getTutorById(Long tutorId) {
        return tutorRepository.findById(tutorId).orElseThrow(
                () -> new IllegalStateException("TUTOR WITH ID " + tutorId +" DOES NOT EXISTS"));
    }

    public void deleteTutor(Long tutorId) {
        tutorRepository.deleteById(tutorId);
    }
}
