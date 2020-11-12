package com.sku.bookshop.web.controller;

import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.service.MemberService;
import com.sku.bookshop.web.dtos.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
public class AccountController {

    private final MemberService memberService;

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
    public String joinForm(@Valid MemberRequestDto requestDto, BindingResult result) {

        if (result.hasErrors()) {
            return "join";
        }

        Long memberNum = memberService.saveMember(requestDto);
        return "redirect:/login";
    }
}
