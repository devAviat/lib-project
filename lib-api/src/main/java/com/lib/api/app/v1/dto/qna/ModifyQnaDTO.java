package com.lib.api.app.v1.dto.qna;

import lombok.Data;

@Data
public class ModifyQnaDTO {
    private Long id;
    private String qnaTitle;
    private String qnaContent;

}
