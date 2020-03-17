package com.kiezik.ComputerService.data.model;

import com.kiezik.ComputerService.enums.TicketStatus;
import com.kiezik.ComputerService.enums.TicketTypes;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime startDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repairDate;

    @Column
    private TicketTypes type;

    @Column
    private TicketStatus status;

    @Column
    private String description;

    @Column
    private Long estimatedCost;

    @ManyToOne
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
