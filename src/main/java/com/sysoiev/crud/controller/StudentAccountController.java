package com.sysoiev.crud.controller;

import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.repository.StudentAccountRepository;
import com.sysoiev.crud.repository.impl.StudentAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class StudentAccountController {
    private StudentAccountRepository studentAccountRepository = new StudentAccountRepositoryImpl();

    public List<StudentAccount> printAll() throws IOException {
        return studentAccountRepository.getAll();
    }

    public void saveStudentAccount(StudentAccount account) throws IOException {
        studentAccountRepository.save(account);
    }

    public void deleteStudentAccount(Long id) {
        studentAccountRepository.deleteById(id);
    }

    public void updateStudentAccount(StudentAccount account) {
        studentAccountRepository.update(account);
    }

    public StudentAccount getValueById(Long id) throws IOException {
        return studentAccountRepository.getById(id);
    }
}
