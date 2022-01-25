package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_rent_cnt")
    private int userRentCnt;

    @Column(name = "user_barcode")
    private String userBarcode;

    @Column(name = "user_state")
    private String userState;

    @Column(name = "user_phone_number")
    private String userPhoneNumber;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "user")
    List<RentUser> rentUsers = new ArrayList<>();

    @Builder
    public User(CreateUserDTO param) {
        this.userId = param.getId();
        this.userName = param.getName();
        this.userPhoneNumber = param.getNumber();
        this.userState = param.getState();
        this.createDate = LocalDateTime.now();
        this.userRentCnt = 5;
    }
}
