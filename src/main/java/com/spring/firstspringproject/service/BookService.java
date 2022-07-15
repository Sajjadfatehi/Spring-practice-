package com.spring.firstspringproject.service;

import com.spring.firstspringproject.model.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookEntity> findById(long id);

    List<BookEntity> findAllByName(String name);

    Iterable<BookEntity> findAll();

    BookEntity insertBook(BookEntity bookEntity);

    void deleteBook(BookEntity bookEntity);

    BookEntity updateBook(BookEntity newBook);

}
