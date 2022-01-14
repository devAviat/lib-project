package com.lib.api.app.v1.service.impl;

import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.repository.BookRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

import static com.lib.api.app.v1.entity.QBook.*;

@Slf4j
public class BookRepositoryImpl implements BookRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final BooleanBuilder builder;

    public BookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.builder = new BooleanBuilder();
    }

    @Override
    public Book findByBookIdx(Long bookIdx) {
        return queryFactory
                .selectFrom(book)
                .where(book.bookIdx.eq(bookIdx))
                .fetchOne();

    }
}
