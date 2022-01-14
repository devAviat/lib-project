package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static com.lib.api.app.config.JPAConfig.createId;

@Entity(name = "USER")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NotNull
    private String user_id;

    @NotNull
    private String user_uuid;

    @NotNull
    private String user_name;

    private String user_barcode;

    private String user_state;

    @NotNull
    private String user_phone_number;

    @Nullable
    private LocalDateTime create_date;

    @Nullable
    private LocalDateTime modify_date;

    @Builder
    public User(CreateUserDTO param) {
        this.user_id = param.getId();
        this.user_name = param.getName();
        this.user_barcode = param.getBarcode();
        this.user_phone_number = param.getNumber();
        this.user_state = param.getState();
        this.user_uuid = createId();
        this.create_date = LocalDateTime.now();
        //this.modify_date = LocalDateTime.now();
    }



}
