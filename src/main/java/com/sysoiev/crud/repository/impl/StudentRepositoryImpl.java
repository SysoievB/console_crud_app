package com.sysoiev.crud.repository.impl;

import com.sysoiev.crud.model.Student;
import com.sysoiev.crud.model.StudentStatus;
import com.sysoiev.crud.model.Subject;
import com.sysoiev.crud.repository.StudentRepository;
import com.sysoiev.crud.repository.SubjectRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private final String filePath = "src\\main\\resources\\students.txt";
    private SubjectRepository subjectRepository = new SubjectRepositoryImpl();
    private List<String> listAllElementsFromFileStudents;
    private Set<Subject> subjects;

    {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            listAllElementsFromFileStudents = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
            subjects = new HashSet<>(subjectRepository.getAll());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public Student getById(Long id) {
        Set<Subject> subjectSet = new HashSet<>();
        for (String s : listAllElementsFromFileStudents) {
            if (s.startsWith(id.toString())) {
                String[] words = s.split(" ");
                for (String word : words) {
                    String subjectValueNameString = subjects.stream().map(Subject::getName).toString();
                    if (word.equals(subjectValueNameString)) {
                        subjectSet.add(new Subject(subjectValueNameString));
                    }
                    return new Student(Long.parseLong(words[0]), words[1], words[2], StudentStatus.valueOf(words[3]), subjectSet);
                }
            }
        }
        Optional<Student> empty = Optional.empty();
        return empty.orElseThrow(NullPointerException::new);
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
        try {
            for (int i = 0; i < listAllElementsFromFileStudents.size(); i++) {
                String line = listAllElementsFromFileStudents.get(i).substring(0, listAllElementsFromFileStudents.get(i).indexOf(' '));
                if (line.equals(String.valueOf(student.getId()))) {
                    listAllElementsFromFileStudents.set(i, student.toString());
                }
            }
            Files.write(Paths.get(filePath), listAllElementsFromFileStudents);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return student;
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

    /*@Override
    public List<Student> getAll() {
        Set<Subject> subjectSet = new HashSet<>();
        return listAllElementsFromFileStudents
                .stream()
                .map(s -> {
                            String[] words = s.split(" ");
                            for (String word : words) {
                                String subjectValueNameString = subjects.stream().map(Subject::getName).toString();
                                if (word.equals(subjectValueNameString)) {
                                    subjectSet.add(new Subject(subjectValueNameString));
                                }
                                return new Student(Long.parseLong(words[0]), words[1], words[2], StudentStatus.valueOf(words[3]), subjectSet);
                            }
                            Optional<Student> empty = Optional.empty();
                            return empty.orElseThrow(NullPointerException::new);
                        }
                )
                .collect(Collectors.toList());
    }*/

    @Override
    public List<Student> getAll() {
        Set<Subject> subjectSet = new HashSet<>();
        return listAllElementsFromFileStudents
                .stream()
                .map(s -> {
                            String[] words = s.split(" ");
                            for (String word : words) {
                                String subjectValueNameString = subjects.stream().map(Subject::getName).toString();
                                if (word.equals(subjectValueNameString)) {
                                    subjectSet.add(new Subject(subjectValueNameString));
                                }
                                return new Student(Long.parseLong(words[0]), words[1], words[2], StudentStatus.valueOf(words[3]), subjectSet);
                            }
                            Optional<Student> empty = Optional.empty();
                            return empty.orElseThrow(NullPointerException::new);
                        }
                )
                .collect(Collectors.toList());
    }
}
