package com.marcosfelipe.bookstoremanager.controller;

import com.marcosfelipe.bookstoremanager.dto.BookDTO;
import com.marcosfelipe.bookstoremanager.dto.MessageResponseDTO;
import com.marcosfelipe.bookstoremanager.entity.Book;
import com.marcosfelipe.bookstoremanager.exception.BookNotFoundException;
import com.marcosfelipe.bookstoremanager.repository.BookRepository;
import com.marcosfelipe.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return bookService.create(bookDTO);
    }

    @DeleteMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }
}
