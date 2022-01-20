package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.rent.CreateRentDTO;
import com.lib.api.app.v1.entity.Book;
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

import java.util.ArrayList;

@Slf4j
@RequestMapping("/v1")
@Api(tags = {"Rent book"})
@RequiredArgsConstructor
@RestController
public class RentController {

    private final RentService rentService;
    private final UserService userService;
    private final BookService bookService;

    @ApiOperation(value = "Book rent.")
    @PostMapping("/rent/book")
    public Rent rentBook(CreateRentDTO createRentDTO) {
        //todo what need to???!
        // first read user information.
        // second what is it user selected book?
        // we need to bookIdx list and userIdx

        //Who rent user?
        User user1 = userService.getOneUser(1L);

        //What kind book list.
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(bookService.getBookOne(1L));
        bookList.add(bookService.getBookOne(4L));

        createRentDTO.setRentCount(bookList.size());
        createRentDTO.setRentTitle(bookList.get(0).getBookName() + "외" +bookList.size()+ "권");
        createRentDTO.setBookList(bookList);
        createRentDTO.setUser(user1);

        String rentTitle = createRentDTO.getRentTitle();

        User user = userService.getOneUser(createRentDTO.getUser().getIdx());
        return rentService.createRent(createRentDTO);

    }
}
