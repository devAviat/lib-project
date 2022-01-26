package com.lib.api.app.v1.entity;

import com.querydsl.core.types.FactoryExpression;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "RENT")
@Data
@NoArgsConstructor
@Slf4j
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

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "rentDetail")
    private List<RentDetail> rentDetailList = new ArrayList<>();

    public static Rent createRent(RentDetail rentDetail) {
        Rent rent = new Rent();
        rent.setCreateDate(LocalDateTime.now());
        log.info("rentDetail :: {}", rentDetail);

        return rent;
    }


}
