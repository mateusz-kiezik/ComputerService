package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.Role;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.data.repositories.UserRepository;
import com.kiezik.ComputerService.enums.AccountStatus;
import com.kiezik.ComputerService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String employeesInit(Model model) {
        model.addAttribute("employees", userService.getEmployees(3L));
        //model.addAttribute("employees", userService.getEmployees(3L, AccountStatus.ENABLED));
        model.addAttribute("employee", new User());
        return "employees";
    }

    @PostMapping
    public String changeStatus(@ModelAttribute("form") User user) {
        Long userId = user.getId();
        userService.changeStatus(userId);
        return "redirect:/employees";
    }


}
