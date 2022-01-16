package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.rent.CreateRentDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "RENT")
@Data
@NoArgsConstructor
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_idx")
    private Long rentIdx;

    @Column(name = "rent_title", nullable = false)
    private String rentTitle;

    @Column(name = "rent_date", nullable = false)
    private LocalDateTime rentDate;

    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate;

    @Column(name = "rent_count", nullable = false)
    private String rentCount;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "modify_date", nullable = true)
    private LocalDateTime modifyDate;

    @Builder
    public Rent(CreateRentDTO param) {
        this.createDate = LocalDateTime.now();
        this.rentCount = param.getRentCount();
        this.rentDate = LocalDateTime.now();
        this.returnDate = LocalDateTime.now().plusDays(15);

    }
}
