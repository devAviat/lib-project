package com.lib.api.app.v1.repository.impl;

import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.repository.BookRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import static com.lib.api.app.v1.entity.QBook.*;

@Slf4j
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final BooleanBuilder builder;

    public BookRepositoryCustomImpl(EntityManager em) {
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

    @Override
    public QueryResults<Book> getSearchBookList(String searchKeyword) {

        if (StringUtils.hasText(searchKeyword)) {
            builder.and(book.bookName.contains(searchKeyword));
        }

        return queryFactory
                .selectFrom(book)
                .where(builder)
                .fetchResults();

    }
}
