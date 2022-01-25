package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.rent.CreateRentDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "RENT")
@Data
@NoArgsConstructor
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_idx")
    private Long rentIdx;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private List<RentInfo> rentInfos = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();


    @Column(name = "rent_title", nullable = true)
    private String rentTitle;

    @Column(name = "rent_date", nullable = true)
    private LocalDateTime rentDate;

    @Column(name = "return_date", nullable = true)
    private LocalDateTime returnDate;

    @Column(name = "rent_count", nullable = true)
    private int rentCount;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Column(name = "modify_date", nullable = true)
    private LocalDateTime modifyDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    public void addRentInfo(RentInfo rentInfo) {
        rentInfos.add(rentInfo);
        rentInfo.setRent(this);
    }

    //==생성 매서드 ==//
    public static Rent createRent(User user, RentInfo... rentInfos) {
        Rent rent = new Rent();
        rent.setUser(user);
        for (RentInfo rents : rentInfos) {
            rent.addRentInfo(rents);
        }
        rent.setRentDate(LocalDateTime.now());
        rent.setCreateDate(LocalDateTime.now());
        return rent;
    }

    @Builder
    public Rent(CreateRentDTO param) {
        this.rentTitle = param.getRentTitle();
        this.rentCount = param.getRentCount();
        this.createDate = LocalDateTime.now();
        this.rentDate = LocalDateTime.now();
        this.returnDate = LocalDateTime.now().plusDays(15);

    }
}
