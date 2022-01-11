package com.lib.api.app.v1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    private Long book_idx;
    private String book_name;
    private String author;
    private Long price;
    private String book_barcode;
}
