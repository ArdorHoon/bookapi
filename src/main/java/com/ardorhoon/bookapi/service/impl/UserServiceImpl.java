package com.ardorhoon.bookapi.service.impl;

import com.ardorhoon.bookapi.model.User;
import com.ardorhoon.bookapi.repository.UserRepository;
import com.ardorhoon.bookapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User create(String nickname, String name, String email, String password) {

        User user = new User();

        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setCreateDate(LocalDateTime.now());
        this.userRepository.save(user);

        return user;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new RuntimeException();
        }
    }
}
