package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.Device;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String customersInit(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("customer", new User());
        return "customers";
    }

    @PostMapping
    @RequestMapping("/add")
    public String addCustomerInit(@ModelAttribute("fromTicket") boolean fromTicket, Model model) {
        model.addAttribute("customer", new User());
        return "add-customer";
    }

    @PostMapping
    @RequestMapping("/edit")
    public String editCustomerInit(@ModelAttribute("customer") User customer,
                                   @ModelAttribute("fromTicket") Boolean fromTicket,
                                   Model model) {
        model.addAttribute("customer", customerService.getCustomer(customer.getId()));
        return "edit-customer";
    }

    @GetMapping
    @RequestMapping("/find")
    public String findCustomerInit(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("selectCustomer", new User());
        return "find-customer";
    }

    @PostMapping
    @RequestMapping("/add-customer")
    public String addCustomer(@ModelAttribute("customer") User customer) {
        customerService.addUser(customer);
        return "redirect:/customers";
    }

    @PostMapping
    @RequestMapping("/edit-customer")
    public String editCustomer(@ModelAttribute("customer") User customer) {
        customerService.editUser(customer);
        return "redirect:/customers";
    }

    @PostMapping
    @RequestMapping("/change-customer")
    public String changeStatus(@ModelAttribute("customer") User user) {
        Long userId = user.getId();
        customerService.changeStatus(userId);
        return "redirect:/customers";
    }

    @PostMapping
    @RequestMapping("/delete-customer")
    public String deleteEmployee(@ModelAttribute("customer") User user) {
        Long userId = user.getId();
        customerService.deleteUser(userId);
        return "redirect:/customers";
    }
}
