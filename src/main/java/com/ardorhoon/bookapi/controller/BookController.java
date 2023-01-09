package com.ardorhoon.bookapi.controller;

import com.ardorhoon.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/book")
    @ResponseBody
    public Map<String, Object> getBook(){
        return bookService.getBook();
    }

}
