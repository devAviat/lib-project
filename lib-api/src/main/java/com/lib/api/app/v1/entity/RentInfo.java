package com.lib.api.app.v1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "RENT_INFO")
@Data
@NoArgsConstructor
public class RentInfo {
    @Id
    @GeneratedValue
    @Column(name = "rent_info_idx")
    private Long rentInfoIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "rentInfo")
    private Rent rent;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "rentBookInfo")
    private Book book;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "rentInfos")
    private User userRentInfo;


    //== 생성매서드 ==//
    public static RentInfo createRentInfo(User user, Book rent) {
        RentInfo rent_info = new RentInfo();
        rent_info.setBook(rent);
        rent_info.setUserRentInfo(user);
        return rent_info;
    }

}
