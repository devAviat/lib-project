package com.lib.api.app.v1.dto.rent;

import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateRentDTO {
    private User user;
    private List<Book> book = new ArrayList<>();
    private String rentTitle;
    private int rentCount;
}
