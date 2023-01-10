package com.ardorhoon.bookapi.service;

import com.ardorhoon.bookapi.model.User;

public interface UserService {

    User create(String nickname, String name, String email, String password);
}
