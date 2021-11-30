package com.sysoiev.crud.repository.impl;

import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.model.Subject;
import com.sysoiev.crud.repository.SubjectRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectRepositoryImpl implements SubjectRepository {
    private final String filePath = "src\\main\\resources\\subjects.txt";
    private List<String> listAllElementsFromFileSubjects;

    {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            listAllElementsFromFileSubjects = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public Subject getById(Long id) {
        for (String s : listAllElementsFromFileSubjects) {
            if (s.startsWith(id.toString())) {
                return new Subject(id, s.substring(s.indexOf(' ')));
            }
        }
        Optional<Subject> empty = Optional.empty();
        return empty.orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteById(Long id) {
        try {
            listAllElementsFromFileSubjects.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
            //delete old file
            Files.delete(Paths.get(filePath));
            //create new file
            File file = new File(filePath);
            file.createNewFile();
            //write Content
            FileWriter writer = new FileWriter(file);
            for (String s : listAllElementsFromFileSubjects) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Subject update(Subject subject) {
        try {
            for (int i = 0; i < listAllElementsFromFileSubjects.size(); i++) {
                String line = listAllElementsFromFileSubjects.get(i).substring(0, listAllElementsFromFileSubjects.get(i).indexOf(' '));
                if (line.equals(String.valueOf(subject.getId()))) {
                    listAllElementsFromFileSubjects.set(i, subject.toString());
                }
            }
            Files.write(Paths.get(filePath), listAllElementsFromFileSubjects);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return subject;
    }

    @Override
    public Subject save(Subject subject) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(subject.toString());
            bufferedWriter.newLine();
            listAllElementsFromFileSubjects.add(subject.toString());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return subject;
    }

    @Override
    public List<Subject> getAll() {

        return listAllElementsFromFileSubjects
                .stream()
                .map(s -> new Subject(Long.parseLong(s.substring(0, s.indexOf(" "))), s.substring(s.indexOf(" "))))
                .collect(Collectors.toList());
    }
}
