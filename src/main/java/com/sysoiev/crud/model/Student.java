package com.sysoiev.crud.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private StudentAccount account;
    private Set<Subject> subjects =new HashSet<>();

    public Student(Long id, String name, String surname, StudentAccount account, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentAccount getAccount() {
        return account;
    }

    public void setAccount(StudentAccount account) {
        this.account = account;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", account=" + account +
                ", subjects=" + subjects +
                '}';
    }
}
