package com.ardorhoon.bookapi;


import com.ardorhoon.bookapi.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @ParameterizedTest
    @MethodSource("userResult")
    public void createUser(String nickname, String name, String email, String password) {
        assertThatCode(() -> userService.create(nickname, name, email, password)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> userResult() {
        return Stream.of(
                arguments("marty", "양훈모", "kazzang@naver.com", "1234"),
                arguments("brave", "Ketty", "ketty23@naver.com", "1234")
        );
    }

}
