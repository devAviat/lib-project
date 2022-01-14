package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.CreateBookDTO;
import com.lib.api.app.v1.dto.ModifyBookDTO;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    /**
     * 등록
     * @param param
     * @return
     */
    @Transactional
    public Book createBook(CreateBookDTO param) {
        Book buildBook = Book
                .builder()
                .param(param)
                .build();
        return bookRepository.save(buildBook);
    }


    @Transactional
    public Book modifyBook(ModifyBookDTO param) {
        Book bookEntity = bookRepository.findByBookIdx(param.getBookIdx());

        bookEntity.setBookAuthor(param.getBookAuthor());
        bookEntity.setBookName(param.getBookName());
        bookEntity.setBookPrice(param.getBookPrice());

        return bookEntity;
    }
}
