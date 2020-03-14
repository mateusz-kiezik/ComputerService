package com.kiezik.ComputerService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-tickets")
public class MyTicketsController {

    @GetMapping
    public String myTicketsInit(Model model) {
        return "my-tickets";
    }
}
