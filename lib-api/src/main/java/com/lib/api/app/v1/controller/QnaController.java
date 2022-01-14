package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.CreateQnaDTO;
import com.lib.api.app.v1.dto.ModifyQnaDTO;
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
    private final QnaRepository qnaRepository;

    /**
     * QNA 등록
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/qna")
    public Qna create(CreateQnaDTO param) {
        return qnaService.createQna(param);
    }

    /**
     * QNA 조회.
     *
     * @param qnaIdx
     * @return
     */
    @GetMapping(value = "/qna/{qnaIdx}")
    public Qna read(@PathVariable Long qnaIdx) {
        return qnaService.read(qnaIdx);
    }

    /**
     * QNA 목록.
     *
     * @return
     */
    @GetMapping(value = "/qna/list")
    public List<Qna> list() {
        return qnaRepository.findAll();
    }

    /**
     * QNA 수정.
     * @param modifyQnaDTO
     * @return
     */
    @PutMapping("/qna")
    public Qna modify(ModifyQnaDTO modifyQnaDTO) {
        return qnaService.modify(modifyQnaDTO);
    }

}
