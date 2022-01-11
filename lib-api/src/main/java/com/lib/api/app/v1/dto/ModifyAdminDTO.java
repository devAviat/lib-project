package com.lib.api.app.v1.dto;

import lombok.Data;

@Data
public class ModifyAdminDTO {
    private Long idx;

    private String name;

    private String grade;

    private String authority;
}
