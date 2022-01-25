package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.lib.api.app.config.JPAConfig.createId;


@Data
@NoArgsConstructor
@Entity(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_rent_cnt", nullable = false)
    private int userRentCnt;

    @Column(name = "user_barcode", nullable = true)
    private String userBarcode;

    @Column(name = "user_state", nullable = true)
    private String userState;

    @Column(name = "user_phone_number", nullable = true)
    private String userPhoneNumber;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Column(name = "modify_date", nullable = true)
    private LocalDateTime modifyDate;


    @Builder
    public User(CreateUserDTO param) {
        this.userId = param.getId();
        this.userUuid = createId();
        this.userName = param.getName();
        this.userPhoneNumber = param.getNumber();
        this.userState = param.getState();
        this.createDate = LocalDateTime.now();
        this.userRentCnt = 5;
    }

    public void createRentInfo(int rentCnt) {
        int restUserRentCnt = this.userRentCnt - rentCnt;
        if (restUserRentCnt < 0) {
            throw new IllegalStateException("현재 사용자는 도서를 대여할수 없습니다.");
        }
        this.userRentCnt = restUserRentCnt;
    }

}
