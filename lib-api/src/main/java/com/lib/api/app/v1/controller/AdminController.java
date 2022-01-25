package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.admin.CreateAdminDTO;
import com.lib.api.app.v1.dto.admin.ModifyAdminDTO;
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

/**
 * @author MG.KIM
 * @version v1
 * @createDate 2021-01-11
 */

@Slf4j
@RequestMapping("/v1")
@Api(tags = {"관리자 관리"})
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @ApiOperation(value = "관리자 생성")
    @PostMapping(value = "/admin")
    public Admin create(CreateAdminDTO domain) {
        return adminService.setCreateAdmin(domain);
    }

    @ApiOperation(value = "관리자 상세내역")
    @GetMapping(value = "/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> detailOne(@PathVariable Long id) {
        Admin admin = adminService.getOneAdmin(id);
        return ResponseEntity.ok(admin);
    }

    @ApiOperation(value = "관리자 목록")
    @GetMapping(value = "/admin/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(adminService.getListAdmin());
    }

    @ApiOperation(value = "관리자 수정")
    @PutMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list(ModifyAdminDTO param) {
        Admin admin = adminService.setModifyAdmin(param);
        return ResponseEntity.ok().body(admin);
    }

}
