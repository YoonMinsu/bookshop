package com.sku.bookshop.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

//    private final BoardService boardService


    @GetMapping("/list")
    public String listPage() {
        return "board/list";
    }

    @GetMapping("/post")
    public String postForm() {
        return "board/post";
    }

    @GetMapping("/update")
    public String updateForm() {
        return "board/update";
    }
}

