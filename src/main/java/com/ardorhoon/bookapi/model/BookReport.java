package com.ardorhoon.bookapi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BookReport")
public class BookReport {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

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
