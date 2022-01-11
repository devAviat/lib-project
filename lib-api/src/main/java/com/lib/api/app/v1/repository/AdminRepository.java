package com.lib.api.app.v1.repository;


import com.lib.api.app.v1.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>, AdminRepositoryCustom {
}

