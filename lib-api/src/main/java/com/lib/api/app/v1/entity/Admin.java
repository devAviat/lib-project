package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.admin.CreateAdminDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "ADMIN")
@NoArgsConstructor
@Data
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "admin_id", nullable = false)
    private String adminId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "grade", nullable = true)
    private String grade;

    @Column(name = "authority", nullable = true)
    private String authority;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "create_by", updatable = false)
    private String createBy;

    @Builder
    public Admin(CreateAdminDTO param) {
        this.adminId = param.getAdmin_id();
        this.name = param.getName();
        this.grade = param.getGrade();
        this.authority = param.getAuthority();
    }


}
