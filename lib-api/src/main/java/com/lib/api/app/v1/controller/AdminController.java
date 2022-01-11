package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.CreateAdminDTO;
import com.lib.api.app.v1.dto.ModifyAdminDTO;
import com.lib.api.app.v1.entity.Admin;
import com.lib.api.app.v1.repository.AdminRepository;
import com.lib.api.app.v1.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/v1")
@Api(tags = {"관리자 관리"})
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminRepository adminRepository;
    private final AdminService adminService;

    @ApiOperation(value = "관리자 생성")
    @PostMapping(value = "/admin")
    public Admin create(CreateAdminDTO domain) {
        log.info("test:{}", domain);
        return adminService.createAdmin(domain);
    }

    @ApiOperation(value = "관리자 상세내역")
    @GetMapping(value = "/admin/{adminIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> detailOne(@PathVariable Long adminIdx) {
        Admin admin = adminService.readOneAdmin(adminIdx);
        log.info("test :: {}", admin);
        return ResponseEntity.ok(admin);
    }

    @ApiOperation(value = "관리자 목록")
    @GetMapping(value = "/admin/adminList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list() {
        List<Admin> all = adminRepository.findAll();
        log.info("admin List :: {}", all);
        return ResponseEntity.ok(all);
    }

    @ApiOperation(value = "관리자 수정")
    @PutMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list(ModifyAdminDTO param) {
        Admin admin = adminService.modifyAdmin(param);
        return ResponseEntity.ok().body(admin);
    }

}
