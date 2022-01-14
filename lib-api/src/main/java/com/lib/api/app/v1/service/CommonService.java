package com.lib.api.app.v1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.lib.api.app.config.JPAConfig.localDateTimeToPlainText;

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
                        .concat(localDateTimeToPlainText(createDate))
                        .concat(String.valueOf(entityIdx));

        log.info("barCodeInfo :: {}", barCodeInfo);
        return barCodeInfo;
    }
}
