package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-tickets")
public class MyTicketsController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String myTicketsInit(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("tickets", ticketService.getCustomerTickets(username));
        return "my-tickets";
    }
}
