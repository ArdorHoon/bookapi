package com.ardorhoon.bookapi.service;

import java.util.Map;

public interface BookService {

     void create(String title, String author);
     Map<String, Object> getBook();
}
