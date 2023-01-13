package com.ardorhoon.bookapi.controller;


import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.model.BookReport;
import com.ardorhoon.bookapi.model.User;
import com.ardorhoon.bookapi.service.BookReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookReport")
public class BookReportController {

    private final BookReportService bookReportService;

    @PostMapping("/create")
    public BookReport createUser(@RequestBody User user,
                                 @RequestBody Book book,
                                 @RequestParam String content,
                                 @RequestParam int rating
    ) {
        return bookReportService.create(book, user, content, rating);
    }

}
