package com.sku.bookshop.web.controller;

import com.sku.bookshop.domain.board.Board;
import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.service.BoardService;
import com.sku.bookshop.web.dtos.board.PostDetailResponseDto;
import com.sku.bookshop.web.dtos.board.PostListResponseDto;
import com.sku.bookshop.web.dtos.board.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/post")
    public String postForm(Model model) {
        model.addAttribute("post", new PostRequestDto());
        return "board/post";
    }

    @PostMapping("/post")
    public String postRegister(PostRequestDto requestDto, @AuthenticationPrincipal Member member) {

        requestDto.setWriter(member.getUserid());

        boardService.savePost(requestDto);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String listPage(Model model) {
        List<PostListResponseDto> boardList = boardService.findAllDesc();
        model.addAttribute("list", boardList);
        return "board/list";
    }

    @GetMapping("/{num}")
    public String updateForm(@PathVariable("num")Long num, Model model) {
        PostDetailResponseDto dto = boardService.findDetailPost(num);

        model.addAttribute("board", dto);

        return "board/detail";
    }
}

