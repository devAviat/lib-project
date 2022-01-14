package com.lib.api.app.v1.repository;

import com.lib.api.app.v1.entity.Book;

public interface BookRepositoryCustom {
    Book findByBookIdx(Long bookIdx);
}
