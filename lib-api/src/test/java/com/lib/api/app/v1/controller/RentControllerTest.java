package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.book.CreateBookDTO;
import com.lib.api.app.v1.dto.user.CreateUserDTO;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.entity.Rent;
import com.lib.api.app.v1.entity.RentDetail;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.service.BookService;
import com.lib.api.app.v1.service.RentService;
import com.lib.api.app.v1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@Transactional
class RentControllerTest {

    @Autowired
    private RentService rentService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Autowired
    private EntityManager em;

    @Test
    void rent_book() throws Exception {

        setCreateUserTest();
        setCreateBookTest();

        User oneUser = userService.getOneUser(1L);

        Book bookOne1 = bookService.getBookOne(3L);
        Book bookOne2 = bookService.getBookOne(2L);

        RentDetail rentDetail = new RentDetail();
        rentDetail.setRentBook(bookOne1);
        rentDetail.setRentBook(bookOne2);

        Rent rent = new Rent();
        rent.getRentDetailList().add(rentDetail);

        log.info("oneUser :: {}", oneUser);
        log.info("bookOne1 :: {}", bookOne1);
        log.info("bookOne2 :: {}", bookOne2);
        log.info("rent :: {}", rent);

    }

    private void setCreateBookTest() {
        CreateBookDTO dto1 = new CreateBookDTO();
        dto1.setAuthor("이순신");
        dto1.setName("JPA master");
        dto1.setPrice(2000L);

        CreateBookDTO dto2 = new CreateBookDTO();
        dto2.setAuthor("장보고2");
        dto2.setName("JPA junior");
        dto2.setPrice(4000L);

        CreateBookDTO dto3 = new CreateBookDTO();
        dto3.setAuthor("류성룡");
        dto3.setName("JAVA Stater");
        dto3.setPrice(10000L);

        CreateBookDTO dto4 = new CreateBookDTO();
        dto4.setAuthor("장보고");
        dto4.setName("React Master");
        dto4.setPrice(7000L);

        setBuildBook(dto1);
        setBuildBook(dto2);
        setBuildBook(dto3);
        setBuildBook(dto4);
    }

    private void setBuildBook(CreateBookDTO dto1) {
        Book build = Book
                .builder()
                .param(dto1)
                .build();

        em.persist(build);
    }

    private void setCreateUserTest() {
        CreateUserDTO paramUser = new CreateUserDTO();
        paramUser.setName("유저");
        paramUser.setNumber("000-222-2222");
        paramUser.setState("RUN");
        paramUser.setId("USER-1");

        User userEntity = User
                .builder()
                .param(paramUser)
                .build();

        em.persist(userEntity);
    }
}