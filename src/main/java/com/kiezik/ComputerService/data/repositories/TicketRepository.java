package com.kiezik.ComputerService.data.repositories;

import com.kiezik.ComputerService.data.model.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findAll();
}
