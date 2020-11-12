package com.sku.bookshop.web.dtos.board;


import com.sku.bookshop.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostListResponseDto {

    private Long num;

    private String title;

    private String writer;

    private LocalDateTime createDateTime;

    public PostListResponseDto(Board entity) {
        this.num = entity.getNum();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.createDateTime = entity.getCreatedDate();
    }
}
