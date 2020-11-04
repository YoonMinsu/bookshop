package com.sku.bookshop.service.board;

import com.sku.bookshop.domains.board.Board;
import com.sku.bookshop.domains.board.BoardRepository;
import com.sku.bookshop.web.dtos.board.BoardDetail;
import com.sku.bookshop.web.dtos.board.BoardListResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardListResponse> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardDetail findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        return BoardDetail.builder().entity(board).build();
    }

}
