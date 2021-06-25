package com.marcosfelipe.bookstoremanager.service;

import com.marcosfelipe.bookstoremanager.dto.MessageResponseDTO;
import com.marcosfelipe.bookstoremanager.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BookService {

    private BookService bookService;

    @Autowired
    public BookService(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(Book book){
        return bookService.create(book);
    }
}
