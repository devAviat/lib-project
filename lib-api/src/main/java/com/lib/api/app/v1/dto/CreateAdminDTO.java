package com.lib.api.app.v1.dto;

import lombok.Data;

@Data
public class CreateAdminDTO {

    private String admin_id;

    private String name;

    private String grade;

    private String authority;
}
