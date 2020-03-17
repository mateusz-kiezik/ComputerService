package com.kiezik.ComputerService.data.repositories;

import com.kiezik.ComputerService.data.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findAll();

    Optional<Device> findFirstBySerialNumber(String serialNumber);

    Optional<Device> findFirstById(Long id);
}
