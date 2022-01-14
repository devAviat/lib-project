package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import com.lib.api.app.v1.dto.user.ModifyUserDTO;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.lib.api.app.config.BarcodeGenerator.*;
import static com.lib.api.app.v1.service.CommonService.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    /**
     * 사용자 생성.
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Transactional
    public User userCreate(CreateUserDTO param) throws Exception {
        User build = User
                .builder()
                .param(param)
                .build();

        // USER Entity 삽입.
        User saveUserEntity = userRepository
                .save(build);

        String userBarcodeInfo = makeBarcodeText("U", saveUserEntity.getUser_uuid(), saveUserEntity.getCreate_date(), saveUserEntity.getIdx());

        // USER barcodeText 주입.
        saveUserEntity.setUser_barcode(userBarcodeInfo);
        createBarcodeImage(userBarcodeInfo);

        return userRepository
                .save(build);
    }


    /**
     * 사용자 조회.
     *
     * @param userIdx
     * @return
     */
    public User userReadOne(Long userIdx) {
        return userRepository.findByIdx(userIdx);
    }

    /**
     * 사용자 목록 조회.
     *
     * @return
     */
    public List<User> userList() {
        return userRepository.findAll();
    }

    /**
     * 사용자 정보 수정.
     *
     * @param param
     * @return
     */
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
