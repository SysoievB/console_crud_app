package com.sysoiev.crud.repository.impl;

import com.sysoiev.crud.model.Student;
import com.sysoiev.crud.repository.StudentRepository;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private final String filePath = "src\\main\\resources\\students.txt";

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
