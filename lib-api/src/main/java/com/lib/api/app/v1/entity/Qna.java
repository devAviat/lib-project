package com.lib.api.app.v1.entity;

import com.lib.api.app.v1.dto.qna.CreateQnaDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "QNA")
@Data
@NoArgsConstructor
public class Qna {

    @Id
    @GeneratedValue
    @Column(name = "qna_idx")
    private Long qnaIdx;

    @Column(name = "qna_title", nullable = false)
    private String qnaTitle;

    @Column(name = "qna_content", nullable = false)
    private String qnaContent;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "create_by", updatable = false)
    private String createBy;

    @Builder
    public Qna(CreateQnaDTO param) {
        this.qnaTitle = param.getQnaTitle();
        this.qnaContent = param.getQnaContent();
    }
}
