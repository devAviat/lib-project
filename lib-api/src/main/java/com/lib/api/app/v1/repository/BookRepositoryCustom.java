package com.lib.api.app.v1.repository;

import com.lib.api.app.v1.dto.common.Search;
import com.lib.api.app.v1.entity.Book;
import com.querydsl.core.QueryResults;

import java.util.List;

public interface BookRepositoryCustom {
    Book findByBookIdx(Long bookIdx);

    QueryResults<Book> getSearchBookList(Search search);

}
