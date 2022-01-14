package com.lib.api.app.v1.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateBookDTO {
    private String name;
    private String author;
    private Long price;
    private String barcode;

}
