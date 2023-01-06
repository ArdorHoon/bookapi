package com.ardorhoon.bookapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Column(name="author", nullable = false, length = 50)
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<BookReport> bookReportList;

    @Column(name="createDate", nullable = false)
    private LocalDateTime createDate;

    @Column(name="modifyDate")
    private LocalDateTime modifyDate;
}
