package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.CreateUserDTO;
import com.lib.api.app.v1.dto.ModifyUserDTO;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User userCreate(CreateUserDTO param) {
        log.info("param :: {}", param);

        User build = User
                .builder()
                .param(param)
                .build();
        log.info("build :: {}", build);

        return userRepository
                .save(build);
    }

    public User userReadOne(Long userIdx) {
        return userRepository.findByIdx(userIdx);
    }

    public List<User> userList() {
        return userRepository.findAll();
    }

    @Transactional
    public User modify(ModifyUserDTO param) {
        User user = userRepository.findByIdx(param.getIdx());
        user.setUser_name(param.getName());
        user.setUser_barcode(param.getBarcode());
        user.setUser_phone_number(param.getNumber());
        user.setUser_state(param.getState());

        return user;
    }
}
