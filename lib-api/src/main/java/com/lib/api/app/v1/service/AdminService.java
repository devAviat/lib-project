package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.CreateAdminDTO;
import com.lib.api.app.v1.dto.ModifyAdminDTO;
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
 * @updateDate
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
     * @param param
     * @return
     */
    @Transactional
    public Admin createAdmin(CreateAdminDTO param) {
        return adminRepository.save(Admin.builder().param(param).build());
    }

    /**
     * 광리자 정보 상세.
     * @param adminIdx
     * @return
     */
    public Admin readOneAdmin(Long adminIdx) {
        return adminRepository.findByIdx(adminIdx);
    }


    /**
     * 관리자 정보 수정.
     * @param param
     * @return
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
