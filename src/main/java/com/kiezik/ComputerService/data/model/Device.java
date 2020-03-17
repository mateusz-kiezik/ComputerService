package com.kiezik.ComputerService.data.model;

import com.kiezik.ComputerService.enums.DeviceTypes;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private DeviceTypes type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String serialNumber;

    @Column
    private Boolean powerSupply;

    @Column
    private Boolean battery;

    @Column
    private Boolean bag;

    @Column
    private String description;

    @OneToMany(mappedBy = "device")
    private List<Ticket> tickets;
}
