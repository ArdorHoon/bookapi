package com.ardorhoon.bookapi;

import com.ardorhoon.bookapi.service.BookService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class BookTests {

    @Autowired
    private BookService bookService;

    @ParameterizedTest
    @MethodSource("bookInfoResult")
    void createTest(String title, String author) {
        assertThatCode(() -> bookService.create(title, author)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> bookInfoResult() {
        return Stream.of(
                arguments("워런 버핏의 주주 서한", "워런 버핏"),
                arguments("나무", "베르나르 베르베르")
        );
    }

}
