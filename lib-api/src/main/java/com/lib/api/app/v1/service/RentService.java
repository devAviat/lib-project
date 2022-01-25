package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.rent.CreateRentRequestDTO;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.entity.Rent;
import com.lib.api.app.v1.entity.RentInfo;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RentService {
    private final UserService userService;
    private final BookService bookService;
    private final RentRepository rentRepository;

    @Transactional
    public Rent setRent(CreateRentRequestDTO param) {

        //find User entity
        User oneUser = userService.getOneUser(param.getUserIdx());
        Book bookOne = bookService.getBookOne(param.getBookIdx());

        RentInfo rentInfo = RentInfo.createRentInfo(oneUser, bookOne);

        Rent rent = Rent.createRent(oneUser,rentInfo );

        return rentRepository.save(rent);
    }

    private void checkUpAvailableBookRent(Book.BookStatus bookStatus) {
        if (bookStatus == Book.BookStatus.RENT) {
            throw new IllegalStateException("현재 대여중인 책으로 대여할수 없습니다.");
        }
    }
}
