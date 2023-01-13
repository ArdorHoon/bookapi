package com.ardorhoon.bookapi.service;

import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.model.BookReport;
import com.ardorhoon.bookapi.model.User;

public interface BookReportService {

    BookReport create(Book book, User user, String Content, int rating);
}
