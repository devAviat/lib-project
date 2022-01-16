package com.lib.api.app.v1.repository.impl;

import com.lib.api.app.v1.entity.Qna;
import com.lib.api.app.v1.repository.QnaRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

import static com.lib.api.app.v1.entity.QQna.*;

@Slf4j
public class qnaRepositoryImpl implements QnaRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final BooleanBuilder builder;

    public qnaRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.builder = new BooleanBuilder();
    }

    @Override
    public Qna findByQnaIdx(Long qnaIdx) {
        return queryFactory
                .selectFrom(qna)
                .where(qna.qnaIdx.eq(qnaIdx)).fetchOne();

    }
}
