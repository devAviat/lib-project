package com.lib.api.app.v1.dto.user;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String id;
    private String name;
    private String number;
    private String state;
}
