package com.lib.api.app.v1.entity;

import com.querydsl.core.types.FactoryExpression;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "RENT")
@Data
@NoArgsConstructor
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Long rent_id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "total_rent_cnt")
    private int totalRentCnt;

    @OneToMany(mappedBy = "rentUser", cascade = CascadeType.PERSIST)
    private List<RentUser> rentUserList = new ArrayList<>();

    @OneToMany(mappedBy = "rentDetail", cascade = CascadeType.PERSIST)
    private List<RentDetail> rentDetailList = new ArrayList<>();

}
