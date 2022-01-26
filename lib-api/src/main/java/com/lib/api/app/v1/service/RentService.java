package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.rent.CreateRentRequestDTO;
import com.lib.api.app.v1.entity.*;
import com.lib.api.app.v1.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        User oneUser = userService.getOneUser(2L);
        Book bookOne = bookService.getBookOne(3L);

        RentDetail rentDetail = RentDetail.createRentDetail(bookOne);

        Rent rent = Rent.createRent(rentDetail);

        return rentRepository.save(rent);
    }

    private void checkUpAvailableBookRent(Book.BookStatus bookStatus) {
        if (bookStatus == Book.BookStatus.RENT) {
            throw new IllegalStateException("현재 대여중인 책으로 대여할수 없습니다.");
        }
    }
}
