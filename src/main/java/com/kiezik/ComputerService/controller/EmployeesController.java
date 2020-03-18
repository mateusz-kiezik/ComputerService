package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String employeesInit(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
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
        employeeService.addEmployee(user);
        return "redirect:/employees";
    }

    @PostMapping
    @RequestMapping("/change-employee")
    public String changeStatus(@ModelAttribute("employee") User user) {
        Long userId = user.getId();
        employeeService.changeStatus(userId);
        return "redirect:/employees";
    }

    @PostMapping
    @RequestMapping("/delete-employee")
    public String deleteEmployee(@ModelAttribute("employee") User user) {
        Long userId = user.getId();
        employeeService.deleteEmployee(userId);
        return "redirect:/employees";
    }


}
