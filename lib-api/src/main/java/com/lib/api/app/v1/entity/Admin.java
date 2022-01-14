package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.admin.CreateAdminDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "ADMIN")
@NoArgsConstructor
@Data
public class Admin {

    @Id
    @GeneratedValue
    private Long idx;

    private String admin_id;

    private String name;

    private String grade;

    private String authority;

    @Builder
    public Admin(CreateAdminDTO param) {
        this.admin_id = param.getAdmin_id();
        this.name = param.getName();
        this.grade = param.getGrade();
        this.authority = param.getAuthority();
    }


}
