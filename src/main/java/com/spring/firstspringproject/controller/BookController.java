package com.spring.firstspringproject.controller;

import com.spring.firstspringproject.model.BookEntity;
import com.spring.firstspringproject.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<BookEntity> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public BookEntity insertBook(
            @RequestBody BookEntity bookEntity
    ) {
        return bookService.insertBook(bookEntity);
    }

    @GetMapping(path = "{id}")
    public BookEntity findById(
            @PathVariable(name = "id")
            Long id
    ) {
        return bookService.findById(id).orElseThrow();
    }

    @DeleteMapping
    void deleteBook(@RequestBody BookEntity bookEntity) {
        bookService.deleteBook(bookEntity);
    }

    @PutMapping
    BookEntity updateBook(@RequestBody BookEntity bookEntity) {
        return bookService.updateBook(bookEntity);
    }


}
   /* @GetMapping
    public String book(
            @RequestParam(
                    value = "name",
                    defaultValue = "amo sajjad"
            )
            String name,
            Model model
    ){
//        model.addAttribute("user",name);

        return name;
    }*/