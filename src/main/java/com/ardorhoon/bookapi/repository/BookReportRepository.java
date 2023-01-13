package com.ardorhoon.bookapi.repository;

import com.ardorhoon.bookapi.model.BookReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReportRepository extends JpaRepository<BookReport, Long> {
}
