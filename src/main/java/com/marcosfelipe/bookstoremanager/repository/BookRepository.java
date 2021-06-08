package com.marcosfelipe.bookstoremanager.repository;

import com.marcosfelipe.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
