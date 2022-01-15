package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.rent.CreateRentDTO;
import com.lib.api.app.v1.entity.Rent;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.service.BookService;
import com.lib.api.app.v1.service.RentService;
import com.lib.api.app.v1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1")
@Api(tags = {"도서 대여"})
@RequiredArgsConstructor
@RestController
public class RentController {

    private final RentService rentService;
    private final UserService userService;
    private final BookService bookService;

    @ApiOperation(value = "도서 대여.")
    @PostMapping("/book")
    public Rent rentBook(CreateRentDTO createRentDTO) {
        //todo what need to???!
        // first read user information.
        // second what is it user selected book?
        // we need to bookIdx list and userIdx

        // User info.
        User user = userService.userReadOne(createRentDTO.getUser().getIdx());
        return rentService.createRent(createRentDTO);

    }
}
