package com.lib.api.app.v1.service;

import com.lib.api.app.config.JPAConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static com.lib.api.app.config.BarcodeGenerator.generateCode128BarcodeImage;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommonService {

    // 사용자 바코드 정보 취합.
    public static String makeBarcodeText(String type, String uuid, LocalDateTime createDate, Long entityIdx) {

        String barCodeInfo =
                type
                        .concat(uuid)
                        .concat(JPAConfig.localDateTimeToPlainText(createDate))
                        .concat(String.valueOf(entityIdx));

        log.info("barCodeInfo :: {}", barCodeInfo);
        return barCodeInfo;
    }

    public static void createBarcodeImage(String barcodeText) throws Exception {
        //바코드 이미지 생성.
        BufferedImage barcodeBufferedImage = generateCode128BarcodeImage(barcodeText);

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
}
