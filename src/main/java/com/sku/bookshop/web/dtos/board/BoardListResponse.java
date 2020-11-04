package com.sku.bookshop.web.dtos.board;

import com.sku.bookshop.domains.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class BoardListResponse {

    private final Long id;

    private final String title;

    private final String writer;

    private final LocalDateTime createdTime;

    @Builder
    public BoardListResponse(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.createdTime = entity.getCreatedDate();
    }
}
