package com.sku.bookshop.web.dtos.board;

import com.sku.bookshop.domain.board.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDetailResponseDto {

    private final Long num;

    private final LocalDateTime createDateTime;

    private final String title;

    private final String writer;

    private final String content;

    public PostDetailResponseDto(Board entity) {
        this.num = entity.getNum();
        this.createDateTime = entity.getCreatedDate();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.content = entity.getContent();
    }
}
