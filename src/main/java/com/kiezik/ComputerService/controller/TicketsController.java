package com.kiezik.ComputerService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    @GetMapping
    public String ticketsInit(Model model) {
        return "tickets";
    }
}
