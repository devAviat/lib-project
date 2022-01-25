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

@Entity(name = "BOOK")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_price")
    private Long bookPrice;

    @Enumerated(STRING)
    @Column(name = "book_status")
    private BookStatus bookStatus;

    @Column(name = "book_barcode")
    private String bookBarcode;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_by")
    private String createBy;

    @OneToMany(mappedBy = "rentBook",cascade = CascadeType.PERSIST)
    List<RentDetail> rentDetailList = new ArrayList<>();

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
