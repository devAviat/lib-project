package com.lib.api.app.v1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "USER")
public class User {
    @Id
    @GeneratedValue
    private Long user_idx;

    private String user_id;

    private String user_name;

    private String user_barcode;

    private String phone_number;

    private LocalDateTime create_date;

    private LocalDateTime modify_date;
}
