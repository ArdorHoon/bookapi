package com.ardorhoon.bookapi;

import com.ardorhoon.bookapi.service.BookService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class BookTest {

    @Autowired
    private BookService bookService;

    @ParameterizedTest
    @MethodSource("bookInfoResult")
    void createTest(String title, List<String> author, String image, String isbn) {
        assertThatCode(() -> bookService.create(title, author, image, isbn)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> bookInfoResult() {
        return Stream.of(
                arguments("워런 버핏의 주주 서한", List.of("워런 버핏", "로렌스 커닝햄"), null, "1188754645 9791188754649"),
                arguments("나무", List.of("베르나르 베르베르"), "http://test.com.wow", "8960927325 9788960927322")
        );
    }

}
