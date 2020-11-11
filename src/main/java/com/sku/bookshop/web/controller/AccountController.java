package com.sku.bookshop.web.controller;

import com.sku.bookshop.service.MemberService;
import com.sku.bookshop.web.dtos.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class AccountController {

    private final MemberService memberService;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute(new MemberRequestDto());
        return "join";
    }

    @PostMapping("/join")
    public String joinForm(MemberRequestDto requestDto) {
        memberService.saveMember(requestDto);
        return "redirect:/login";
    }
}
