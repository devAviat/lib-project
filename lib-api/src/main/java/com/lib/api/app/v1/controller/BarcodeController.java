package com.lib.api.app.v1.controller;

import com.lib.api.app.config.ZxingGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;

import static com.lib.api.app.config.ZxingGenerator.*;

@Controller
@Slf4j
@RequestMapping("/v1")
public class BarcodeController {

    //정상 작동 안함.
    @GetMapping(value = "/barbecue/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable("barcode") String barcode)
            throws Exception {
        return ResponseEntity.ok(ZxingGenerator.generateEAN13BarcodeImage(barcode));
    }

    @GetMapping(value = "/barbecue/code128/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueCode128Barcode(@PathVariable("barcode") String barcode)
            throws Exception {
        return ResponseEntity.ok(ZxingGenerator.generateCode128BarcodeImage(barcode));
    }

    @GetMapping(value = "/barbecue/qrCode/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueQrCodeBarcode(@PathVariable("barcode") String barcode)
            throws Exception {
        return ResponseEntity.ok(ZxingGenerator.generateQRCodeImage(barcode));
    }



}
