package com.sku.bookshop.web.dtos.board;

import com.sku.bookshop.domains.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardListResponse {

    private Long id;

    private String title;

    private String writer;

    @Builder
    public BoardListResponse(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
    }
}
