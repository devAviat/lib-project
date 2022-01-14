package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.CreateUserDTO;
import com.lib.api.app.v1.dto.ModifyUserDTO;
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
import static com.lib.api.app.config.JPAConfig.*;
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

        // USER barcodeText 주입.
        saveUserEntity.setUser_barcode(makeBarcodeText("U", saveUserEntity.getUser_uuid(), saveUserEntity.getCreate_date(), saveUserEntity.getIdx()));
        createBarcodeImage(saveUserEntity);

        return userRepository
                .save(build);
    }

    private void createBarcodeImage(User save) throws Exception {
        //바코드 이미지 생성.
        BufferedImage barcodeBufferedImage = generateCode128BarcodeImage(makeBarcodeText("U", save.getUser_uuid(), save.getCreate_date(), save.getIdx()));

        //String root = request.getSession().getServletContext().getRealPath("resources"); //현재 서비스가 돌아가고 있는 서블릿 경로의 resources 폴더 찾기

        String savePath = "root" + "\\qrCodes\\"; // 파일 경로

        //파일 이름에 저장한 날짜를 포함해주기 위해 date생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = sdf.format(new Date()) + barcodeBufferedImage.toString();

        //파일 경로, 파일 이름 , 파일 확장자에 맡는
        // 파일 생성
        File temp = new File(savePath + fileName + ".png");

        log.info("barcodeBufferedImage :: {}", barcodeBufferedImage);

        // ImageIO를 사용하여 파일쓰기
        ImageIO.write(barcodeBufferedImage, "png", temp);
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
