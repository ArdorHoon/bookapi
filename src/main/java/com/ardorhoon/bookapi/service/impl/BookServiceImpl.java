package com.ardorhoon.bookapi.service.impl;

import com.ardorhoon.bookapi.repository.BookRepository;
import com.ardorhoon.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

}
