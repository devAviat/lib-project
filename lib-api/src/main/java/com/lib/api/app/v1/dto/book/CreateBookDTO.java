package com.lib.api.app.v1.dto.book;

import lombok.Data;

@Data
public class CreateBookDTO {
    private String name;
    private String author;
    private Long price;
}
