package com.sysoiev.crud.controller;

import com.sysoiev.crud.model.Subject;
import com.sysoiev.crud.repository.SubjectRepository;
import com.sysoiev.crud.repository.impl.SubjectRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SubjectController {
    private SubjectRepository subjectRepository = new SubjectRepositoryImpl();

    public List<Subject> printAll() throws IOException {
        return subjectRepository.getAll();
    }

    public void saveSubject(Subject subject) throws IOException {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    public void updateSubject(Subject subject) {
        subjectRepository.update(subject);

    }

    public Subject getValueById(Long id) throws IOException {
        return subjectRepository.getById(id);
    }
}
