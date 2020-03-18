package com.kiezik.ComputerService.service;

import com.kiezik.ComputerService.data.model.Device;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.data.repositories.DeviceRepository;
import com.kiezik.ComputerService.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private CustomerService customerService;


    public void addDevice(Device device) {
        deviceRepository.save(device);
    }

    public Long addDeviceandGetId(Device device) {
        if (device.getId() == null) {
            return deviceRepository.save(device).getId();
        } else
        return device.getId();
    }


    public void editDevice(Device device) {
        deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {
        List<Device> devicesList = deviceRepository.findAll();
        return devicesList;
    }

    public Device getDeviceBySerialNumber(String serialNumber) {
        Device device = deviceRepository.findFirstBySerialNumber(serialNumber).get();
        return device;
    }

    public Device getDeviceById(Long id) {
        Device device = deviceRepository.findFirstById(id).get();
        return device;
    }
}
