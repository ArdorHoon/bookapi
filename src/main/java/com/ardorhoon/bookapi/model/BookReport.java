package com.ardorhoon.bookapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BookReport")
public class BookReport {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name="createDate", nullable = false)
    private LocalDateTime createDate;

    @Column(name="modifyDate")
    private LocalDateTime modifyDate;
}
