package com.sysoiev.crud.view;

import com.sysoiev.crud.controller.StudentController;
import com.sysoiev.crud.model.Student;
import com.sysoiev.crud.model.StudentStatus;
import com.sysoiev.crud.model.Subject;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentView {
    private final Scanner scanner;
    private final StudentController studentController;

    public StudentView() {
        scanner = new Scanner(System.in);
        studentController = new StudentController();
    }

    public void printStudents() {
        System.out.println("List of all students: ");
        try {
            studentController.printAll().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        System.out.println("Enter id in order to delete row: ");
        Long index = Long.parseLong(scanner.next());
        studentController.deleteStudent(index);
    }

    public void getByIdStudent() {
        System.out.println("Enter id in order to get student:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (studentController.getValueById(id) != null)
                System.out.println(studentController.getValueById(id).toString());

        } catch (NullPointerException | IOException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdStudent();
        }
    }


    public void saveStudent() {
        System.out.println("Enter id: ");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter surname:");
        String surname = scanner.next();
        System.out.println("Enter name of subject:");
        Set<Subject> subjectSet = new HashSet<>();
        String nameOfSubject = scanner.next();
        subjectSet.add(new Subject(nameOfSubject));
        boolean go = true;
        while (go) {
            System.out.println("Do You want to add new name of subject? 1.Yes 2.No");
            String yesOrNo = scanner.next();
            switch (yesOrNo) {
                case ("1"):
                    System.out.println("Enter name of new subject:");
                    String nameOfNewSubject = scanner.next();
                    subjectSet.add(new Subject(nameOfNewSubject));
                    break;
                case ("2"):
                    System.out.println("You choose do not add new subject");
                    go = false;
                    break;
            }
        }
        System.out.println("Enter status: PRIMARY, SECONDARY, GRADUATE, please");
        String statusName = scanner.next();
        StudentStatus status = StudentStatus.valueOf(statusName);
        Student newStudent = new Student(id, name, surname, status, subjectSet);
        try {
            studentController.saveStudent(newStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        System.out.println("Enter id in order to find element:");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter surname:");
        String surname = scanner.next();
        System.out.println("Enter name of subject:");
        Set<Subject> subjectSet = new HashSet<>();
        String nameOfSubject = scanner.next();
        subjectSet.add(new Subject(nameOfSubject));
        boolean go = true;
        while (go) {
            System.out.println("Do You want to add new name of subject? 1.Yes 2.No");
            String yesOrNo = scanner.next();
            switch (yesOrNo) {
                case ("1"):
                    System.out.println("Enter name of new subject:");
                    String nameOfNewSubject = scanner.next();
                    subjectSet.add(new Subject(nameOfNewSubject));
                    break;
                case ("2"):
                    System.out.println("You choose do not add new subject");
                    go = false;
                    break;
            }
        }
        System.out.println("Enter status: PRIMARY, SECONDARY, GRADUATE, please");
        String statusName = scanner.next();
        StudentStatus status = StudentStatus.valueOf(statusName);
        Student newStudent = new Student(id, name, surname, status, subjectSet);
        studentController.updateStudent(newStudent);
    }

    public void run() {
        boolean go = true;
        while (go) {
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printStudents();
                    break;
                case 2:
                    saveStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    getByIdStudent();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 6, please");
            }
        }
    }
}
