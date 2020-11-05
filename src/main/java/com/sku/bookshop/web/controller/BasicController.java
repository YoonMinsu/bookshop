package com.sku.bookshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping("/login")
    public String userLogin() {
        return "login";
    }

    @GetMapping("/join")
    public String userRegister() {
        return "join";
    }
}
