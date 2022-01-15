package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.rent.CreateRentDTO;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.entity.Rent;
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
    private final RentRepository rentRepository;

    public Rent createRent(CreateRentDTO param) {

        Rent build = Rent.builder().param(param).build();

        return rentRepository.save(build);

    }
}
