package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.rent.CreateRentRequestDTO;
import com.lib.api.app.v1.entity.Rent;
import com.lib.api.app.v1.service.RentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1")
@Api(tags = {"Rent book"})
@RequiredArgsConstructor
@RestController
public class RentController {

   /* private final RentService rentService;

    @ApiOperation(value = "Book rent.")
    @PostMapping("/rent/book")
    public Rent rentBook(@RequestBody CreateRentRequestDTO param) {
        return rentService.setRent(param);
    }*/
}
