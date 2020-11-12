package com.sku.bookshop.service;

import com.sku.bookshop.domain.board.Board;
import com.sku.bookshop.domain.board.BoardRepository;
import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.web.dtos.board.PostDetailResponseDto;
import com.sku.bookshop.web.dtos.board.PostListResponseDto;
import com.sku.bookshop.web.dtos.board.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long savePost(PostRequestDto requestDto) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        Member member = (Member) authentication.getPrincipal();

        Board board = requestDto.toEntity();
        board.setPostMember(member);
        return boardRepository.save(board).getNum();
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostDetailResponseDto findDetailPost(Long num) {
        Board board = boardRepository.getOne(num);

        return new PostDetailResponseDto(board);
    }

}
