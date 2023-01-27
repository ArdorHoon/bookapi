package com.ardorhoon.bookapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "author", nullable = false)
    @ElementCollection
    private List<String> author;

    @Column(name = "image")
    private String image;

    @Column(name = "isbn", nullable = false, length = 50, unique = true)
    private String isbn;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    @JsonBackReference //순환참조 방지
    private List<BookReport> bookReportList;

    @Column(name = "createDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime createDate;

    @Column(name = "modifyDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime modifyDate;
}
