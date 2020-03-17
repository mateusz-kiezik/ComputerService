package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.Device;
import com.kiezik.ComputerService.data.model.Ticket;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.enums.TicketStatus;
import com.kiezik.ComputerService.service.DeviceService;
import com.kiezik.ComputerService.service.EmployeeService;
import com.kiezik.ComputerService.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public String ticketsInit(Model model) {
        return "tickets";
    }

    @GetMapping
    @RequestMapping("/add")
    public String addTicketInit(@ModelAttribute("device")Device device, Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("deviceA", device);
        return "add-ticket";
    }

    @PostMapping
    @RequestMapping("/add-ticket")
    public String addTicket(@ModelAttribute("ticket") Ticket ticket) {
        ticketService.addTicket(ticket);
        return "redirect:/tickets";
    }
}