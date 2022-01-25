package com.lib.api.app.v1.dto.rent;

import lombok.Data;

import java.util.List;


@Data
public class CreateRentRequestDTO {
    private Long user_idx;
    private Long bookIdx;
}
