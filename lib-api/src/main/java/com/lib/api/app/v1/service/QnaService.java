package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.qna.CreateQnaDTO;
import com.lib.api.app.v1.dto.qna.ModifyQnaDTO;
import com.lib.api.app.v1.entity.Qna;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QnaService {

    private final QnaRepository qnaRepository;

    /**
     * 등록
     * @param param
     * @return
     */
    @Transactional
    public Qna setCreateQna(CreateQnaDTO param) {
        Qna buildQna = Qna
                .builder()
                .param(param)
                .build();

        return qnaRepository.save(buildQna);

    }

    /**
     * 단건 조회.
     * @param qnaIdx
     * @return
     */
    public Qna getOneQna(Long qnaIdx) {
        return qnaRepository.findByQnaIdx(qnaIdx);
    }

    /**
     * 수정
     * @param param
     * @return
     */
    @Transactional
    public Qna setModifyQna(ModifyQnaDTO param) {
        Qna findQna = qnaRepository.findByQnaIdx(param.getQnaIdx());

        findQna.setQnaTitle(param.getQnaTitle());
        findQna.setQnaContent(param.getQnaContent());

        return findQna;
    }

    public List<Qna> getListQna() {
        return qnaRepository.findAll();
    }
}
