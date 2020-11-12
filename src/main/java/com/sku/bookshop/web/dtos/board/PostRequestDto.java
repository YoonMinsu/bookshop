package com.sku.bookshop.web.dtos.board;

import com.sku.bookshop.domain.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    private String title;

    private String writer;

    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .writer(writer)
                .content(content)
                .build();
    }
}
