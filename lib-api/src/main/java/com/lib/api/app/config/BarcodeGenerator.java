package com.lib.api.app.config;

import org.springframework.context.annotation.Configuration;

import java.awt.image.BufferedImage;

@Configuration
public class BarcodeGenerator {

    /**
     * CODE 128
     * @param barCodeInfo
     * @return
     * @throws Exception
     */
    public static BufferedImage generateCode128BarcodeImage(String barCodeInfo) throws Exception {
        return ZxingGenerator.generateCode128BarcodeImage(barCodeInfo);
    }
    /**
     *
     */

}
