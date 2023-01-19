package com.ardorhoon.bookapi;

import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.model.User;
import com.ardorhoon.bookapi.service.BookReportService;
import com.ardorhoon.bookapi.service.BookService;
import com.ardorhoon.bookapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@SpringBootTest
public class BookReportTest {

    @Autowired
    private BookReportService bookReportService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Test
    public void createBookReport() {

        Book book = bookService.getBookByIsbn("1188754645 9791188754649");
        User user = userService.getUserById(1L);

        assertThatCode(() -> bookReportService.create(book, user, "독후감 내용", 4)).doesNotThrowAnyException();
    }


}
