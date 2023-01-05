package com.ardorhoon.bookapi.controller;

import com.ardorhoon.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    
}
