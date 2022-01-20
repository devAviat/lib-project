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
    public User setCreateUser(CreateUserDTO param) throws Exception {
        User build = User
                .builder()
                .param(param)
                .build();

        // USER Entity 삽입.
        User saveUserEntity = userRepository
                .save(build);

        String userBarcodeInfo = makeBarcodeText("U", saveUserEntity.getUserUuid(), saveUserEntity.getCreateDate(), saveUserEntity.getIdx());

        // USER barcodeText 주입.
        saveUserEntity.setUserBarcode(userBarcodeInfo);
        //createBarcodeImage(userBarcodeInfo);

        return userRepository
                .save(build);
    }


    /**
     * 사용자 조회.
     *
     * @param userIdx
     * @return
     */
    public User getOneUser(Long userIdx) {
        return userRepository.findByIdx(userIdx);
    }

    /**
     * 사용자 목록 조회.
     *
     * @return
     */
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    /**
     * 사용자 정보 수정.
     *
     * @param param
     * @return
     */
    @Transactional
    public User setModifyUser(ModifyUserDTO param) {
        User user = userRepository.findByIdx(param.getIdx());
        user.setUserName(param.getName());
        user.setUserBarcode(param.getBarcode());
        user.setUserPhoneNumber(param.getNumber());
        user.setUserState(param.getState());

        return user;
    }


}
