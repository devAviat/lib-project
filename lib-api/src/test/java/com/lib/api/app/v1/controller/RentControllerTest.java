package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.service.BookService;
import com.lib.api.app.v1.service.RentService;
import com.lib.api.app.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
@AutoConfigureMockMvc
class RentControllerTest {

    @Autowired
    private final RentService rentService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final BookService bookService;


    @Test
    void rent_book_scenario() {


    }
}