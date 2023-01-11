package com.ardorhoon.bookapi.repository;

import com.ardorhoon.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByIsbn(String isbn);
}
