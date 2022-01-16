package com.lib.api.app.v1.dto.common;

import com.lib.api.app.v1.entity.Book;
import lombok.Data;

@Data
public class CommonDTO {

    private Search search;

    private Book book;
}
