package com.ardorhoon.bookapi.service;

import com.ardorhoon.bookapi.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    void create(String title, List<String> author, String img, String isbn);

    Map<String, Object> getBook();

    Book getBookByIsbn(String isbn);
}
