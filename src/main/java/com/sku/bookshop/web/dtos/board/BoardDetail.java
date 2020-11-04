package com.sku.bookshop.web.dtos.board;

import com.sku.bookshop.domains.board.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class BoardDetail {

    private final Long id;

    private final String title;

    private final String content;

    private final String writer;

    private final LocalDateTime createdDate;

    @Builder
    public BoardDetail(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.createdDate = entity.getCreatedDate();
    }
}
