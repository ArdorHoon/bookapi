package com.ardorhoon.bookapi.service.impl;

import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.repository.BookRepository;
import com.ardorhoon.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void create(String title, List<String> author, String img, String isbn) {

        Book book = new Book();

        book.setCreateDate(LocalDateTime.now());
        book.setAuthor(author);
        book.setTitle(title);
        book.setImage(img);
        book.setIsbn(isbn);
        bookRepository.save(book);

    }

    @Override
    @Transactional
    public Map<String, Object> getBook() {
        Map<String, Object> result = new HashMap<>();
        List<Book> bookList = bookRepository.findAll();

        result.put("books", bookList);
        return result;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findBookByIsbn(isbn);

        if (book.isPresent()) {
            return book.get();
        } else
            throw new RuntimeException();
    }
}
