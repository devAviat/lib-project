package com.lib.api.app.v1.dto.rent;

import lombok.Data;


@Data
public class CreateRentRequestDTO {
    private Long userIdx;
    private Long rent ;
    private Long bookIdx;

}
