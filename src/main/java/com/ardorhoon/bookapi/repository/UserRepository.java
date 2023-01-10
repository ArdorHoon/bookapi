package com.ardorhoon.bookapi.repository;

import com.ardorhoon.bookapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
