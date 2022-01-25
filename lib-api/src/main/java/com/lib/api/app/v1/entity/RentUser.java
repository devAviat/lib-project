package com.lib.api.app.v1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "RENT_USER")
@Data
@NoArgsConstructor
public class RentUser {
    @Id
    @GeneratedValue
    @Column(name = "rent_user_id")
    private Long rentUserId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rent_id")
    private Rent rentUser;

}
