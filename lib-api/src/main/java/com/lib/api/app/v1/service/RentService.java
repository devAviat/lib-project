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
        param.setUser_idx(2L);
        param.setBookIdx(3L);

        User oneUser = userService.getOneUser(param.getUser_idx());
        Book bookOne = bookService.getBookOne(param.getBookIdx());

        RentUser rentUser = new RentUser();
        rentUser.setUser(oneUser);

        RentDetail rentDetail = new RentDetail();
        rentDetail.setRentBook(bookOne);

        Rent rent = new Rent();
        rent.getRentUserList().add(rentUser);
        rent.getRentDetailList().add(rentDetail);

        return rentRepository.save(rent);
    }

    private void checkUpAvailableBookRent(Book.BookStatus bookStatus) {
        if (bookStatus == Book.BookStatus.RENT) {
            throw new IllegalStateException("현재 대여중인 책으로 대여할수 없습니다.");
        }
    }
}
