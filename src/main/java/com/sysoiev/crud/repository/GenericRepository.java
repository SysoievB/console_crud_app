package com.sysoiev.crud.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id) throws IOException;

    void deleteById(ID id) ;

    T update(T item) ;

    T save(T item) throws IOException;

    List<T> getAll() throws IOException;
}
