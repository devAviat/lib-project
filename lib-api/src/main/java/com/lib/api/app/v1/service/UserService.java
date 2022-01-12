package com.lib.api.app.v1.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.lib.api.app.config.ZxingGenerator;
import com.lib.api.app.v1.dto.CreateUserDTO;
import com.lib.api.app.v1.dto.ModifyUserDTO;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.image.BufferedImage;
import java.util.List;

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
        User save = userRepository
                .save(build);

        // 사용자 바코드 정보 취합.
        /**
         * String barcode_info = "LIB+UUID+20220112155200+IDX";
         */
        String barcode_info = "LIB"
                + save.getUser_uuid()
                + save.getCreate_date()
                + save.getIdx();

        log.info("barcode_info :: {}", barcode_info);

        //바코드 생성
        //todo -바코드 이미지 저장.
        BufferedImage qrCode = createBarCode(barcode_info);

        return userRepository
                .save(build);
    }

    /**
     * 바코드 생성.
     *
     * @param barcode_info
     * @return
     * @throws Exception
     */
    private BufferedImage createBarCode(String barcode_info) throws Exception {
        return ZxingGenerator.generateCode128BarcodeImage(barcode_info);
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
