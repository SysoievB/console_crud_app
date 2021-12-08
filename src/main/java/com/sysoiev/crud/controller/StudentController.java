package com.sysoiev.crud.controller;

import com.sysoiev.crud.model.Student;
import com.sysoiev.crud.repository.StudentRepository;
import com.sysoiev.crud.repository.impl.StudentRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class StudentController {
    private StudentRepository studentRepository = new StudentRepositoryImpl();

    public List<Student> printAll() throws IOException {
        return studentRepository.getAll();
    }

    public void saveStudent(Student student) throws IOException {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    public Student getValueById(Long id) throws IOException {
        return studentRepository.getById(id);
    }
}
