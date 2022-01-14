package com.lib.api.app.v1.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.lib.api.app.config.BarcodeGenerator;
import com.lib.api.app.config.JPAConfig;
import com.lib.api.app.config.ZxingGenerator;
import com.lib.api.app.v1.dto.CreateUserDTO;
import com.lib.api.app.v1.dto.ModifyUserDTO;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.lib.api.app.config.BarcodeGenerator.*;
import static com.lib.api.app.config.JPAConfig.*;

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
    public User userCreate(CreateUserDTO param, HttpServletRequest request, HttpSession session) throws Exception {
        User build = User
                .builder()
                .param(param)
                .build();

        // USER Entity 삽입.
        User saveUserEntity = userRepository
                .save(build);

        // USER barcodeText 주입.
        saveUserEntity.setUser_barcode(getMakeBarcodeText(saveUserEntity));
        createBarcodeImage(saveUserEntity, request, session);

        return userRepository
                .save(build);
    }

    private void createBarcodeImage(User save, HttpServletRequest request, HttpSession session) throws Exception {
        //바코드 이미지 생성.
        BufferedImage barcodeBufferedImage = generateCode128BarcodeImage(getMakeBarcodeText(save));

        String root = request.getSession().getServletContext().getRealPath("resources"); //현재 서비스가 돌아가고 있는 서블릿 경로의 resources 폴더 찾기

        String savePath = root + "\\qrCodes\\"; // 파일 경로

        //파일 이름에 저장한 날짜를 포함해주기 위해 date생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = sdf.format(new Date()) + barcodeBufferedImage.toString();

        //파일 경로, 파일 이름 , 파일 확장자에 맡는 파일 생성
        File temp = new File(savePath + fileName + ".png");

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

    // 사용자 바코드 정보 취합.
    private String getMakeBarcodeText(User save) {

        String barCodeInfo = "LIB"
                + save.getUser_uuid() //uuid
                + localDateTimeToPlainText(save.getCreate_date())//localDateTime
                + save.getIdx();//user index

        log.info("barCodeInfo :: {}", barCodeInfo);
        return barCodeInfo;
    }
}
