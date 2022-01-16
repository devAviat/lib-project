package com.lib.api.app.v1.repository.impl;

import com.lib.api.app.v1.entity.Admin;
import com.lib.api.app.v1.entity.QAdmin;
import com.lib.api.app.v1.repository.AdminRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class AdminRepositoryImpl implements AdminRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final BooleanBuilder builder;

    public AdminRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.builder = new BooleanBuilder();
    }

    @Override
    public Admin findByIdx(Long adminIdx) {
        Admin admin = queryFactory
                .selectFrom(QAdmin.admin)
                .where(QAdmin.admin.idx.eq(adminIdx))
                .fetchOne();

        log.info("end :: {}", admin);

        return admin;
    }
}
