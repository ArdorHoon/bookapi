package com.ardorhoon.bookapi.controller;

import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@Api(tags = {"Controller that provides book-related APIs"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    @ApiOperation(value = "현재 DB에 저장되어 있는 책 목록")
    public Map<String, Object> getBook() {
        return bookService.getBook();
    }


    @PostMapping("/create")
    public Book create(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "author") List<String> author,
            @RequestParam(value = "image", required = false) String image,
            @RequestParam(value = "isbn") String isbn
    ) {
        bookService.create(title, author, image, isbn);
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping("")
    public Book getBookByIsbn(
            @RequestParam(value = "isbn") String isbn
    ) {
        return bookService.getBookByIsbn(isbn);
    }

}
