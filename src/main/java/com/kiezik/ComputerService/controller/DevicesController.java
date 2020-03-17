package com.kiezik.ComputerService.controller;

import com.kiezik.ComputerService.data.model.Device;
import com.kiezik.ComputerService.data.model.Ticket;
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
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/devices")
public class DevicesController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String devicesInit(Model model) {
        model.addAttribute("devices", deviceService.getAllDevices());
        return "devices";
    }

    @GetMapping
    @RequestMapping("/add")
    public String addDeviceInit(Model model) {
        model.addAttribute("device", new Device());
        return "add-device";
    }

    @GetMapping
    @RequestMapping("/find")
    public String findDeviceInit(Model model) {
        model.addAttribute("devices", deviceService.getAllDevices());
        model.addAttribute("selectDevice", new Device());
        return "find-device";
    }

    @PostMapping
    @RequestMapping("/edit")
    public String editDeviceInit(@ModelAttribute("device") Device device,
                                 @ModelAttribute("fromTicket") boolean fromTicket,
                                 Model model) {

        Device deviceEdit = deviceService.getDeviceById(device.getId());
        model.addAttribute("device", deviceEdit);
        return "edit-device";
    }


    @PostMapping
    @RequestMapping("/add-device")
    public RedirectView addDevice(@ModelAttribute("device") Device device, RedirectAttributes redirectAttributes) {
        RedirectView addTicket = new RedirectView("/tickets/add", true);
        redirectAttributes.addFlashAttribute("device", device);
        deviceService.addDevice(device);
        return addTicket;
    }

    @PostMapping
    @RequestMapping("edit-device")
    public String editDevice(@ModelAttribute("device") Device device) {
        deviceService.editDevice(device);
        return "redirect:/devices";
    }
}
