package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.admin.CreateAdminDTO;
import com.lib.api.app.v1.dto.admin.ModifyAdminDTO;
import com.lib.api.app.v1.entity.Admin;
import com.lib.api.app.v1.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author MG.KIM
 * @version v1
 * @createDate 2022-01-05
 * @description
 * 관리자 등록, 수정, 삭제 서비스
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;

    /**
     * 광리자 정보 등록.
     * @CreateAdminDTO param
     * @return Admin
     */
    @Transactional
    public Admin createAdmin(CreateAdminDTO param) {
        Admin build = Admin.builder().param(param).build();
        log.info("build :: {}", build);
        return adminRepository.save(build);
    }

    /**
     * 광리자 정보 상세.
     * @param adminIdx
     * @return Admin
     */
    public Admin readOneAdmin(Long adminIdx) {
        return adminRepository.findByIdx(adminIdx);
    }


    /**
     * 관리자 정보 수정.
     * @ModifyAdminDTO  param
     * @return Admin
     */
    @Transactional
    public Admin modifyAdmin(ModifyAdminDTO param) {
        Admin adminEntity = adminRepository.findByIdx(param.getIdx());
        adminEntity.setGrade(param.getGrade());
        adminEntity.setAuthority(param.getAuthority());
        adminEntity.setName(param.getName());
        log.info("관리자 정보 수정. ::{}", adminEntity);

        return adminEntity;
    }
}
