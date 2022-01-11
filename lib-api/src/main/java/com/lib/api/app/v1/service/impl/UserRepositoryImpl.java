package com.lib.api.app.v1.service.impl;

import com.lib.api.app.v1.entity.QUser;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.UserRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

import static com.lib.api.app.v1.entity.QUser.user;

@Slf4j
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final BooleanBuilder builder;

    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.builder = new BooleanBuilder();
    }

    /*@Override
    public User findByUserId(String userId) {
        return queryFactory
                .selectFrom(QUser.user)
                .where(user.user_id.eq(userId).isNotNull())
                .fetchOne();
    }*/

    @Override
    public User findByIdx(Long userIdx) {
        return queryFactory
                .selectFrom(QUser.user)
                .where(user.idx.eq(userIdx).isNotNull())
                .fetchOne();

    }
}
