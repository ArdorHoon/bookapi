package com.ardorhoon.bookapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="createDate", nullable = false)
    private LocalDateTime createDate;

    @Column(name="modifyDate", nullable = false)
    private LocalDateTime modifyDate;
}
