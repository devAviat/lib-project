package com.lib.api.app.v1.dto.book;

import lombok.Data;

@Data
public class ModifyBookDTO {
    private Long id;

    private String bookName;

    private String bookAuthor;

    private Long bookPrice;

    private String bookBarcode;
}
