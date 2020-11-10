package com.sku.bookshop.web.controller;

import com.sku.bookshop.web.dto.UserInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("userInfo", new UserInfoDto());
        return "join";
    }

}
