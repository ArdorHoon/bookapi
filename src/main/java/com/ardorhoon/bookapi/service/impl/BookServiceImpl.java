package com.ardorhoon.bookapi.service.impl;

import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.repository.BookRepository;
import com.ardorhoon.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void create(String title, String author) {
        Book book = new Book();

        book.setCreateDate(LocalDateTime.now());
        book.setAuthor(author);
        book.setTitle(title);

        bookRepository.save(book);
    }
}
