package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.Ticket;
import com.kiezik.ComputerService.service.EmployeeService;
import com.kiezik.ComputerService.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @RequestMapping("/{ticketId}")
    public String ticketInit(@PathVariable("ticketId") Long ticketId, Model model) {
        model.addAttribute("employees",  employeeService.getEmployees());
        model.addAttribute("ticket", ticketService.getTicket(ticketId));
        return "ticket";
    }

    @PostMapping
    @RequestMapping("/save")
    public String saveTicket(@ModelAttribute("ticket")Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }

}
