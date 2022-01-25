package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.qna.*;
import com.lib.api.app.v1.entity.Qna;
import com.lib.api.app.v1.repository.QnaRepository;
import com.lib.api.app.v1.service.QnaService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(tags = {"Q&A 관리"})
@RequiredArgsConstructor
@Slf4j
public class QnaController {

    private final QnaService qnaService;

    /**
     * QNA 등록
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/qna")
    public Qna create(CreateQnaDTO param) {
        return qnaService.setCreateQna(param);
    }

    /**
     * QNA 조회.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/qna/{id}")
    public Qna read(@PathVariable Long id) {
        return qnaService.getOneQna(id);
    }

    /**
     * QNA 목록.
     *
     * @return
     */
    @GetMapping(value = "/qna/list")
    public List<Qna> list() {
        return qnaService.getListQna();
    }

    /**
     * QNA 수정.
     * @param modifyQnaDTO
     * @return
     */
    @PutMapping("/qna")
    public Qna modify(ModifyQnaDTO modifyQnaDTO) {
        return qnaService.setModifyQna(modifyQnaDTO);
    }

}
