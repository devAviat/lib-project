package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.book.CreateBookDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.lib.api.app.config.JPAConfig.createId;
import static com.lib.api.app.v1.entity.Book.BookStatus.*;
import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "BOOK")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "book_id", unique = true)
    private String bookId;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_author", nullable = false)
    private String bookAuthor;

    @Column(name = "book_price", nullable = false)
    private Long bookPrice;

    @Enumerated(STRING)
    @Column(name = "book_status", nullable = false)
    private BookStatus bookStatus;

    @Column(name = "book_barcode", unique = true)
    private String bookBarcode;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "create_by", updatable = false)
    private String createBy;

    @Builder
    public Book(CreateBookDTO param) {
        this.bookId = createId();
        this.bookName = param.getName();
        this.bookAuthor = param.getAuthor();
        this.bookPrice = param.getPrice();
        this.createDate = LocalDateTime.now();
        this.bookStatus = READY;
    }


    public enum BookStatus {
        READY, RENT,
        ;

    }
}
