package com.lib.api.app.v1.repository;


import com.lib.api.app.v1.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long>, RentRepositoryCustom {
}

