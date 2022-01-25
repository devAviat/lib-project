package com.lib.api.app.v1.dto.admin;

import lombok.Data;

@Data
public class ModifyAdminDTO {

    private Long id;

    private String name;

    private String grade;

    private String authority;
}
