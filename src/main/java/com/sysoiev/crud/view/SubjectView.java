package com.sysoiev.crud.view;

import com.sysoiev.crud.controller.SubjectController;
import com.sysoiev.crud.model.Subject;

import java.io.IOException;
import java.util.Scanner;

public class SubjectView {
    private Scanner scanner = new Scanner(System.in);
    private SubjectController subjectController = new SubjectController();

    public void printSubjects() {
        System.out.println("List of all subjects : ");
        try {
            System.out.println(subjectController.printAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubject() {
        System.out.println("Enter id in order to delete row : ");
        Long index = Long.parseLong(scanner.next());
        subjectController.deleteSubject(index);
    }

    public void getByIdSubject() {
        System.out.println("Enter id in order to get subject :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (subjectController.getValueById(id) != null)
                System.out.println(subjectController.getValueById(id).toString());

        } catch (NullPointerException | IOException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdSubject();
        }
    }

    public void saveSubject() {
        System.out.println("Enter id : ");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter subject : ");
        String subject = scanner.next();
        Subject newSubject = new Subject(id, subject);
        try {
            subjectController.saveSubject(newSubject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSubject() {
        System.out.println("Enter id in order to find element :");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter new subject : ");
        String subject = scanner.next();
        Subject newSubject = new Subject(id, subject);
        subjectController.updateSubject(newSubject);
    }

    public void run() {
        boolean go = true;
        while (go) {
            System.out.println("\nChoose option, please :");
            System.out.println("Enter number : ");
            System.out.println("1. Show all rows");
            System.out.println("2. Insert new row");
            System.out.println("3. Delete row ");
            System.out.println("4. Update row  ");
            System.out.println("5. Search by id ");
            System.out.println("6. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printSubjects();
                    break;
                case 2:
                    saveSubject();
                    break;
                case 3:
                    deleteSubject();
                    break;
                case 4:
                    updateSubject();
                    break;
                case 5:
                    getByIdSubject();
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

