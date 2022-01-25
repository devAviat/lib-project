package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.admin.CreateAdminDTO;
import com.lib.api.app.v1.dto.admin.ModifyAdminDTO;
import com.lib.api.app.v1.entity.Admin;
import com.lib.api.app.v1.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Admin setCreateAdmin(CreateAdminDTO param) {
        Admin build = Admin.builder().param(param).build();
        log.info("build :: {}", build);
        return adminRepository.save(build);
    }

    /**
     * 광리자 정보 상세.
     * @param id
     * @return Admin
     */
    public Admin getOneAdmin(Long id) {
        return adminRepository.findById(id).orElse(null);
    }


    /**
     * 관리자 정보 수정.
     * @ModifyAdminDTO  param
     * @return Admin
     */
    @Transactional
    public Admin setModifyAdmin(ModifyAdminDTO param) {
        Admin oneAdmin = getOneAdmin(param.getId());
        oneAdmin.setGrade(param.getGrade());
        oneAdmin.setAuthority(param.getAuthority());
        oneAdmin.setName(param.getName());
        log.info("관리자 정보 수정. ::{}", oneAdmin);

        return oneAdmin;
    }

    public List<Admin> getListAdmin() {
        return adminRepository.findAll();
    }
}
