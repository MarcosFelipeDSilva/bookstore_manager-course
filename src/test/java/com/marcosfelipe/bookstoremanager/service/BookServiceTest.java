package com.marcosfelipe.bookstoremanager.service;

import com.marcosfelipe.bookstoremanager.dto.BookDTO;
import com.marcosfelipe.bookstoremanager.entity.Book;
import com.marcosfelipe.bookstoremanager.exception.BookNotFoundException;
import com.marcosfelipe.bookstoremanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.marcosfelipe.bookstoremanager.utils.BookUtils.createFakeBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenGivenExistingIdThenReturnThisBook() throws BookNotFoundException {
        Book expectedFoundBook = createFakeBook();

        when(bookRepository.findById(expectedFoundBook.getId())).thenReturn(Optional.of(expectedFoundBook));

        BookDTO bookDTO = bookService.findById(expectedFoundBook.getId());

        assertEquals(expectedFoundBook.getName(), bookDTO.getName());
        assertEquals(expectedFoundBook.getIsbn(), bookDTO.getIsbn());
        assertEquals(expectedFoundBook.getPublisherName(), bookDTO.getPublisherName());
    }

    @Test
    void whenGivenUnexistingIdThenNotFindThrowAnException() {
        var invalid =10L;

        when(bookRepository.findById(invalid)).thenReturn(Optional.ofNullable(any(Book.class)));
        assertThrows(BookNotFoundException.class, () -> bookService.findById(invalid));
    }
}
