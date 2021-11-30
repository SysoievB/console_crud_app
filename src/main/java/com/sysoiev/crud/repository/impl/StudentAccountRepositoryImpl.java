package com.sysoiev.crud.repository.impl;

import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.repository.StudentAccountRepository;

import java.util.List;

public class StudentAccountRepositoryImpl implements StudentAccountRepository {
    private final String filePath = "src\\main\\resources\\accounts.txt";

    @Override
    public StudentAccount getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public StudentAccount update(StudentAccount account) {
        return null;
    }

    @Override
    public StudentAccount save(StudentAccount account) {
        return null;
    }

    @Override
    public List<StudentAccount> getAll() {
        return null;
    }
}
