package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.book.CreateBookDTO;
import com.lib.api.app.v1.dto.book.ModifyBookDTO;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.lib.api.app.v1.service.CommonService.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    /**
     * 등록
     *
     * @param param
     * @return
     */
    @Transactional
    public Book createBook(CreateBookDTO param) {

        Book buildBook = Book
                .builder()
                .param(param)
                .build();

        Book saveBook = bookRepository.save(buildBook);

        saveBook.setBookBarcode(makeBarcodeText("B", saveBook.getBookId(), saveBook.getCreateDate(), saveBook.getBookIdx()));

        return saveBook;
    }


    /**
     * 수정.
     * @param param
     * @return
     */
    @Transactional
    public Book modifyBook(ModifyBookDTO param) {
        Book modifyBook = bookRepository.findByBookIdx(param.getBookIdx());

        modifyBook.setBookAuthor(param.getBookAuthor());
        modifyBook.setBookName(param.getBookName());
        modifyBook.setBookPrice(param.getBookPrice());

        return modifyBook;
    }
}
