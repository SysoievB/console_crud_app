package com.sysoiev.crud.repository.impl;

import com.sysoiev.crud.model.Student;
import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.model.StudentStatus;
import com.sysoiev.crud.model.Subject;
import com.sysoiev.crud.repository.StudentAccountRepository;
import com.sysoiev.crud.repository.StudentRepository;
import com.sysoiev.crud.repository.SubjectRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private final String filePath = "src\\main\\resources\\students.txt";
    private SubjectRepository subjectRepository = new SubjectRepositoryImpl();
    private StudentAccountRepository studentAccountRepository = new StudentAccountRepositoryImpl();
    private List<String> listAllElementsFromFileStudents;

    {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            listAllElementsFromFileStudents = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            listAllElementsFromFileStudents.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
            //delete old file
            Files.delete(Paths.get(filePath));
            //create new file
            File file = new File(filePath);
            file.createNewFile();
            //write Content
            FileWriter writer = new FileWriter(file);
            for (String s : listAllElementsFromFileStudents) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student save(Student student) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
            listAllElementsFromFileStudents.add(student.toString());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return student;
    }

    /*private Long id;
        private String name;
        private String surname;
        private StudentAccount account;
        private Set<Subject> subjects = new HashSet<>();*/
    @Override
    public List<Student> getAll() {
        Set<Subject> subjectSet = new HashSet<>();
        return listAllElementsFromFileStudents
                .stream()
                .map(s -> {
                            String[] words = s.split(" ");
                            for (String word : words) {
                                if (words.length > 3) {

                                }
                            }

                            new Student(Long.parseLong(words[0]), words[1], words[2], StudentStatus.valueOf(words[3]), )
                        }
                )
                .collect(Collectors.toList());
    }
}
/*String str = "Hello This is DelfStack";
        StringTokenizer tokens = new StringTokenizer(str, " ");
        String[] newStr = new String[tokens.countTokens()];
        int index=0;
        while(tokens.hasMoreTokens()){
            newStr[index] = tokens.nextToken();
            System.out.println(newStr[index]);
            index++;
        }*/