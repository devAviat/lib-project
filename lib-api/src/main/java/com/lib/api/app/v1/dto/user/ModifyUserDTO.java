package com.lib.api.app.v1.dto.user;

import lombok.Data;

@Data
public class ModifyUserDTO {
    private Long idx;

    private String name;

    private String barcode;

    private String number;

    private String authority;

    private String state;
}
