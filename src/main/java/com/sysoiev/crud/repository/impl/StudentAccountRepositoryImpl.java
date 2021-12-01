package com.sysoiev.crud.repository.impl;

import com.sysoiev.crud.model.StudentAccount;
import com.sysoiev.crud.model.StudentStatus;
import com.sysoiev.crud.repository.StudentAccountRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentAccountRepositoryImpl implements StudentAccountRepository {
    private final String filePath = "src\\main\\resources\\accounts.txt";
    private List<String> listAllElementsFromFileAccounts;

    {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            listAllElementsFromFileAccounts = bufferedReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public StudentAccount getById(Long id) {
        for (String s : listAllElementsFromFileAccounts) {
            if (s.startsWith(id.toString())) {
                return new StudentAccount(id, StudentStatus.valueOf(s.substring(s.indexOf(' ') + 1)));
            }
        }
        Optional<StudentAccount> empty = Optional.empty();
        return empty.orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteById(Long id) {
        try {
            listAllElementsFromFileAccounts.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
            //delete old file
            Files.delete(Paths.get(filePath));
            //create new file
            File file = new File(filePath);
            file.createNewFile();
            //write Content
            FileWriter writer = new FileWriter(file);
            for (String s : listAllElementsFromFileAccounts) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public StudentAccount update(StudentAccount account) {
        try {
            for (int i = 0; i < listAllElementsFromFileAccounts.size(); i++) {
                String line = listAllElementsFromFileAccounts.get(i).substring(0, listAllElementsFromFileAccounts.get(i).indexOf(' '));
                if (line.equals(String.valueOf(account.getId()))) {
                    listAllElementsFromFileAccounts.set(i, account.toString());
                }
            }
            Files.write(Paths.get(filePath), listAllElementsFromFileAccounts);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return account;
    }

    @Override
    public StudentAccount save(StudentAccount account) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(account.toString());
            bufferedWriter.newLine();
            listAllElementsFromFileAccounts.add(account.toString());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return account;
    }

    @Override
    public List<StudentAccount> getAll() {
        return listAllElementsFromFileAccounts
                .stream()
                .map(s -> new StudentAccount(Long.parseLong(s.substring(0, s.indexOf(" "))), StudentStatus.valueOf(s.substring(s.indexOf(" ") + 1))))
                .collect(Collectors.toList());
    }
}
