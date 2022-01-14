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

@Entity(name = "BOOK")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_idx")
    private Long bookIdx;

    @NotNull
    @Column(name = "book_name")
    private String bookName;

    @NotNull
    @Column(name = "book_author")
    private String bookAuthor;

    @NotNull
    @Column(name = "book_price")
    private Long bookPrice;

    @Column(name = "book_barcode")
    private String bookBarcode;

    @Builder
    public Book(CreateBookDTO param) {
        this.bookName = param.getName();
        this.bookAuthor = param.getAuthor();
        this.bookPrice = param.getPrice();
    }


}
