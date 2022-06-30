package com.sysoiev.crud.view;

import com.sysoiev.crud.controller.StudentAccountController;
import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.model.StudentStatus;

import java.io.IOException;
import java.util.Scanner;

public class StudentAccountView {
    private final Scanner scanner;
    private final StudentAccountController accountController;

    public StudentAccountView() {
        scanner = new Scanner(System.in);
        accountController = new StudentAccountController();
    }

    public void printStudentAccounts() {
        System.out.println("List of all student accounts: ");
        try {
            System.out.println(accountController.printAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentAccount() {
        System.out.println("Enter id in order to delete row: ");
        Long index = Long.parseLong(scanner.next());
        accountController.deleteStudentAccount(index);
    }

    public void getByIdStudentAccount() {
        System.out.println("Enter id in order to get student account:");
        Long id = Long.parseLong(scanner.next());
        try {
            try {
                if (accountController.getValueById(id) != null)
                    System.out.println(accountController.getValueById(id).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdStudentAccount();
        }
    }

    public void saveStudentAccount() {
        System.out.println("Enter id : ");
        Long id = Long.parseLong(scanner.next());
        StudentAccount newAccount = new StudentAccount(id, StudentStatus.PRIMARY);
        try {
            accountController.saveStudentAccount(newAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentAccount() {
        System.out.println("Enter id in order to find element:");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter status : 1.PRIMARY,2.SECONDARY,3.GRADUATE");
        String accountStatusStr = scanner.next();
        StudentStatus accountStatusVar = null;
        switch (accountStatusStr) {
            case "1":
                accountStatusVar = StudentStatus.PRIMARY;
                break;
            case "2":
                accountStatusVar = StudentStatus.SECONDARY;
                break;
            case "3":
                accountStatusVar = StudentStatus.GRADUATE;
                break;
        }
        StudentAccount newAccount = new StudentAccount(id, accountStatusVar);
        accountController.updateStudentAccount(newAccount);
    }

    public void run() {
        boolean go = true;
        while (go) {
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printStudentAccounts();
                    break;
                case 2:
                    saveStudentAccount();
                    break;
                case 3:
                    deleteStudentAccount();
                    break;
                case 4:
                    updateStudentAccount();
                    break;
                case 5:
                    getByIdStudentAccount();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number" +
                            "\nEnter number from 1 to 6, please");
            }
        }
    }
}
