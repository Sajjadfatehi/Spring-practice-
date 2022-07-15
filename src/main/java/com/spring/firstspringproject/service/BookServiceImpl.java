package com.spring.firstspringproject.service;

import com.spring.firstspringproject.dao.BookDao;
import com.spring.firstspringproject.model.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao){
        this.bookDao=bookDao;
    }

    @Override
    public Optional<BookEntity> findById(long id) {
        return bookDao.findById(id);
    }

    @Override
    public List<BookEntity> findAllByName(String name) {
        return bookDao.findAllByName(name);
    }

    @Override
    public Iterable<BookEntity> findAll() {
        return bookDao.findAll();
    }

    @Override
    public BookEntity insertBook(BookEntity bookEntity) {
       return bookDao.save(bookEntity);
    }

    @Override
    public void deleteBook(BookEntity bookEntity) {
        bookDao.delete(bookEntity);
    }

    @Override
    public BookEntity updateBook(BookEntity newBook) {
        var oldBook=findById(newBook.getId()).orElseThrow();
        oldBook.setName(newBook.getName());

        return insertBook(oldBook);
    }
}
