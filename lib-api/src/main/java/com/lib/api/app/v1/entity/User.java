package com.lib.api.app.v1.entity;

import com.lib.api.app.config.JPAConfig;
import com.lib.api.app.v1.dto.user.CreateUserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.lib.api.app.config.JPAConfig.createId;


@Data
@NoArgsConstructor
@Entity(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_barcode", nullable = false)
    private String userBarcode;

    @Column(name = "user_state", nullable = true)
    private String userState;

    @Column(name = "user_phone_number", nullable = true)
    private String userPhoneNumber;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Column(name = "modify_date", nullable = true)
    private LocalDateTime modifyDate;

    @ManyToOne
    @JoinColumn(name = "rend_id")
    private Rent rent;

    @Builder
    public User(CreateUserDTO param) {
        this.userId = param.getId();
        this.userUuid = createId();
        this.userName = param.getName();
        this.userBarcode = param.getBarcode();
        this.userPhoneNumber = param.getNumber();
        this.userState = param.getState();
        this.createDate = LocalDateTime.now();
        //this.modify_date = LocalDateTime.now();
    }


}
