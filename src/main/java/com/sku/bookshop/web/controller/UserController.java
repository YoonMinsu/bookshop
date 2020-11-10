package com.sku.bookshop.web.controller;

import com.sku.bookshop.service.UserService;
import com.sku.bookshop.web.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String registration(@ModelAttribute("userInfo")UserInfoDto dto) {

        userService.userRegister(dto);

        return "redirect:/login";
    }
}
