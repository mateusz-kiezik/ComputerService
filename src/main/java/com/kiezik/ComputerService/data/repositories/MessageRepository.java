package com.kiezik.ComputerService.data.repositories;

import com.kiezik.ComputerService.data.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
