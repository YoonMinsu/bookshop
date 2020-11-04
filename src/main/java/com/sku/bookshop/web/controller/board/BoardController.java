package com.sku.bookshop.web.controller.board;

import com.sku.bookshop.service.board.BoardService;
import com.sku.bookshop.web.dtos.board.BoardDetail;
import com.sku.bookshop.web.dtos.board.BoardListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model) {
        List<BoardListResponse> board = boardService.findAllDesc();
        model.addAttribute("board", board);
        return "board/list";
    }

    @GetMapping("/post")
    public String boardPost() {
        return "board/post";
    }

    @GetMapping("/{id}")
    public String boardDetail(Model model, @PathVariable("id") Long id) {
        BoardDetail board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/detail";
    }


    @GetMapping("/{id}/update")
    public String boardUpdate(Model model, @PathVariable("id") Long id) {
        BoardDetail board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/update";
    }
}
