package com.kiezik.ComputerService.service;

import com.kiezik.ComputerService.data.model.Device;
import com.kiezik.ComputerService.data.model.Ticket;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.data.repositories.TicketRepository;
import com.kiezik.ComputerService.enums.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CustomerService customerService;

    public List<Ticket> getAllTickets() {
        List<Ticket> ticketsList = ticketRepository.findAll();
        return ticketsList;
    }

    public Ticket getTicket(Long ticketId) {
        Ticket ticket = ticketRepository.getFirstById(ticketId);
        return ticket;
    }

    public List<Ticket> getCustomerTickets(String customerUsername) {
        Long customerId = customerService.getCustomerByUsername(customerUsername).getId();
        List<Ticket> ticketsList = ticketRepository.findAllByDevice_Customer_Id(customerId);
        return ticketsList;
    }


    public void addTicket(Ticket ticket) {
        User user = employeeService.getEmployee(ticket.getUser().getId());
        ticket.setUser(user);
        Device device = deviceService.getDeviceById(ticket.getDevice().getId());

        LocalDate repairDate = ticket.getRepairDate();
        ticket.setRepairDate(repairDate);

        ticket.setDevice(device);
        ticket.setStatus(TicketStatus.NEW);
        ticket.setStartDate(LocalDateTime.now());
        ticketRepository.save(ticket);
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
