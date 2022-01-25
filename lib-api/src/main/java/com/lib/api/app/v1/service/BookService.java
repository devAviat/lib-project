package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.book.CreateBookDTO;
import com.lib.api.app.v1.dto.book.ModifyBookDTO;
import com.lib.api.app.v1.dto.common.Search;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.repository.BookRepository;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    /**
     * 도서 등록
     *
     * @param param
     * @return
     */
    @Transactional
    public Book setCreateBook(CreateBookDTO param) {

        Book buildBook = Book
                .builder()
                .param(param)
                .build();

        return bookRepository.save(buildBook);
    }


    /**
     * 도서 수정.
     *
     * @param param
     * @return
     */
    @Transactional
    public Book modifyBook(ModifyBookDTO param) {
        Book modifyBook = getBookOne(param.getId());

        modifyBook.setBookAuthor(param.getBookAuthor());
        modifyBook.setBookName(param.getBookName());
        modifyBook.setBookPrice(param.getBookPrice());

        return modifyBook;
    }

    /**
     * 도서 기본목록.
     *
     * @return
     */
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    /**
     * 도서 단건 조회.
     *
     * @param id
     * @return
     */
    public Book getBookOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    /**
     * 도서 검색 목록.
     *
     * @param searchKeyword
     * @return
     */
    public List<Book> getSearchBookList(Search search) {
        QueryResults<Book> bySearchBook = bookRepository.getSearchBookList(search);
        log.info("bySearchBook :: {}", bySearchBook);
        return bySearchBook.getResults();
    }
}
