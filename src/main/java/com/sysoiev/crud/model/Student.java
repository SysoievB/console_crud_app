package com.sysoiev.crud.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private StudentStatus status;
    private Set<Subject> subjects = new HashSet<>();

    public Student() {

    }

    public Student(Long id, String name, String surname, StudentStatus status, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
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

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String printAllSubjects() {
        return "" + subjects.stream().map(Subject::getName).collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + status.toString() + " " + printAllSubjects();
    }
}
