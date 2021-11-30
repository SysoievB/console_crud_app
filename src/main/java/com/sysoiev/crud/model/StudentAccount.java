package com.sysoiev.crud.model;

public class StudentAccount {
    private Long id;
    private StudentStatus status;

    public StudentAccount() {
    }

    public StudentAccount(Long id, StudentStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " " + status;
    }
}
