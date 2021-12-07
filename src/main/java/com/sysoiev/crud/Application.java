package com.sysoiev.crud;

import com.sysoiev.crud.model.Student;
import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.model.StudentStatus;
import com.sysoiev.crud.model.Subject;
import com.sysoiev.crud.view.CommonView;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws IOException {
        //CommonView.getInstance().run();
        Set<Subject> subjectSet = new HashSet<>();
        subjectSet.add(new Subject(1L,"math"));
        subjectSet.add(new Subject(2L,"geometry"));
        StudentAccount account = new StudentAccount(1L, StudentStatus.SECONDARY);
        Student student =new Student(1L,"vasia","leontiv",account.getStatus(),subjectSet);
        System.out.println(student);

    }
}
