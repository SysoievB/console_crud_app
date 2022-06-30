package com.sysoiev.crud.view;

import java.util.Scanner;

public class CommonView {

    private final StudentAccountView accountView;
    private final StudentView studentView;
    private final SubjectView subjectView;
    private static CommonView view;

    private CommonView() {
        studentView = new StudentView();
        accountView = new StudentAccountView();
        subjectView = new SubjectView();
    }

    public static CommonView getInstance() {
        if (view == null) {
            view = new CommonView();
        }
        return view;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            var variants = "\nChoose file in order to do operations, please:" +
                    "\nEnter number:" +
                    "\n1.Subjects" +
                    "\n2.Students accounts" +
                    "\n3.Students" +
                    "\n4.End";
            System.out.println(variants);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runSubject();
                    break;
                case 2:
                    runStudentAccount();
                    break;
                case 3:
                    runStudent();
                    break;
                case 4:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number" +
                            "\nEnter number from 1 to 4, please");
            }
        }
    }

    public void runSubject() {
        subjectView.run();
    }

    public void runStudentAccount() {
        accountView.run();
    }

    public void runStudent() {
        studentView.run();
    }

}
