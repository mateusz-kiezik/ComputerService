package com.kiezik.ComputerService.service;

import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.data.repositories.UserRepository;
import com.kiezik.ComputerService.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getEmployeesWithStatus(Long role, AccountStatus status) {
        List<User> employeesList = userRepository.findAllByRoles_IdAndStatus(role, status);
        return employeesList;
    }

    public List<User> getEmployees(Long role) {
        List<User> employeesList = userRepository.findAllByRoles_Id(role);
        return employeesList;
    }

    public void changeStatus(Long id) {
        User user = userRepository.findById(id).get();
        user.setStatus(AccountStatus.DISABLED);
        userRepository.save(user);
    }
}
