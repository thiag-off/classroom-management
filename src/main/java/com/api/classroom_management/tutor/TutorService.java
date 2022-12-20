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
}
