package com.ardorhoon.bookapi.service.impl;

import com.ardorhoon.bookapi.model.Book;
import com.ardorhoon.bookapi.model.BookReport;
import com.ardorhoon.bookapi.model.User;
import com.ardorhoon.bookapi.repository.BookReportRepository;
import com.ardorhoon.bookapi.service.BookReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookReportServiceImpl implements BookReportService {

    private final BookReportRepository bookReportRepository;

    @Override
    public BookReport create(Book book, User user, String content, int rating) {
        BookReport bookReport = new BookReport();

        bookReport.setBook(book);
        bookReport.setUser(user);
        bookReport.setContent(content);
        bookReport.setRating(rating);
        bookReport.setCreateDate(LocalDateTime.now());

        bookReportRepository.save(bookReport);
        return bookReport;
    }

    @Override
    public BookReport modify(Long id, String content, int rating) {
        Optional<BookReport> bookReport = bookReportRepository.findById(id);

        if (bookReport.isPresent()) {
            BookReport revisionReport = bookReport.get();
            revisionReport.setRating(rating);
            revisionReport.setContent(content);
            return revisionReport;
        } else
            throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        Optional<BookReport> bookReport = bookReportRepository.findById(id);
        if (bookReport.isPresent()) {
            bookReportRepository.delete(bookReport.get());
        } else
            throw new RuntimeException();
    }
}
