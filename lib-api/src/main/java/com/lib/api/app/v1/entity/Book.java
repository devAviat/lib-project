package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.CreateBookDTO;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;

import static com.lib.api.app.config.JPAConfig.createId;

@Entity(name = "BOOK")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_idx")
    private Long bookIdx;

    @Column(name = "book_id", unique = true)
    private String bookId;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_author", nullable = false)
    private String bookAuthor;

    @Column(name = "book_price", nullable = false)
    private Long bookPrice;

    @Column(name = "book_barcode",unique = true)
    private String bookBarcode;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Builder
    public Book(CreateBookDTO param) {
        this.bookId = createId();
        this.bookName = param.getName();
        this.bookAuthor = param.getAuthor();
        this.bookPrice = param.getPrice();
        this.createDate = LocalDateTime.now();
    }


}
