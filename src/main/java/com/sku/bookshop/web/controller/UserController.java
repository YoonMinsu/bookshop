package com.sku.bookshop.web.controller;

import com.sku.bookshop.service.UserService;
import com.sku.bookshop.web.dto.UserInfoDto;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String registration(@Valid UserInfoDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "join";
        }
        userService.userRegister(dto);
        return "redirect:/login";
    }
}
