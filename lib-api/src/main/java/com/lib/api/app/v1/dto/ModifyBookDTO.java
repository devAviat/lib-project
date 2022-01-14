package com.lib.api.app.v1.dto;

import lombok.Data;

@Data
public class ModifyBookDTO {
    private Long bookIdx;

    private String bookName;

    private String bookAuthor;

    private Long bookPrice;

    private String bookBarcode;
}
