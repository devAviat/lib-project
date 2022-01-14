package com.lib.api.app.v1.repository;

import com.lib.api.app.v1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
}
