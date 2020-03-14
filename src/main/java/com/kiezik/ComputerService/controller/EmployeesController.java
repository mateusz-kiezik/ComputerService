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
        model.addAttribute("employees", userService.getEmployees(2L));
        model.addAttribute("employee", new User());
        return "employees";
    }

    @GetMapping
    @RequestMapping("/add")
    public String addEmployeeInit(Model model) {
        model.addAttribute("employee", new User());
        return "add-employee";
    }

    @PostMapping
    @RequestMapping("/add-employee")
    public String addEmployee(@ModelAttribute("employee") User user) {
        userService.addEmployee(user);
        return "redirect:/employees";
    }

    @PostMapping
    @RequestMapping("/change")
    public String changeStatus(@ModelAttribute("employee") User user) {
        Long userId = user.getId();
        userService.changeStatus(userId);
        return "redirect:/employees";
    }

    @PostMapping
    @RequestMapping("/delete")
    public String deleteEmployee(@ModelAttribute("employee") User user) {
        Long userId = user.getId();
        userService.deleteEmployee(userId);
        return "redirect:/employees";
    }


}
