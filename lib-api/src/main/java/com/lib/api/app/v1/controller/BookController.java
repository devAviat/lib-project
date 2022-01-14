package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.book.CreateBookDTO;
import com.lib.api.app.v1.dto.book.ModifyBookDTO;
import com.lib.api.app.v1.entity.Book;
import com.lib.api.app.v1.repository.BookRepository;
import com.lib.api.app.v1.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(tags = {"도서 관리"})
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    @ApiOperation(value = "도서 생성.")
    @PostMapping("/book")
    public Book create(CreateBookDTO createBookDTO) {
        return bookService.createBook(createBookDTO);

    }

    @ApiOperation(value = "도서 단건 조회.")
    @GetMapping(value = "/book/{bookIdx}")
    public Book read(@PathVariable Long bookIdx) {
        return bookRepository.findByBookIdx(bookIdx);
    }

    @ApiOperation(value = "도서 목록.")
    @GetMapping(value = "/book/list")
    public List<Book> list() {
        return bookRepository.findAll();

    }

    @ApiOperation(value = "관리자 수정.")
    @PutMapping("/book")
    public Book update(ModifyBookDTO param) {
        return bookService.modifyBook(param);
    }
}
