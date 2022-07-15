package com.spring.firstspringproject.dao;


import com.spring.firstspringproject.model.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAllByName(String name);

    BookEntity save(BookEntity bookEntity);

}
