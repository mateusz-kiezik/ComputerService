package com.kiezik.ComputerService.service;

import com.kiezik.ComputerService.data.model.Role;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.data.repositories.UserRepository;
import com.kiezik.ComputerService.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getEmployees() {
        List<User> employeesList = userRepository.findAllByRoles_Id(2L);
        return employeesList;
    }

    public void changeStatus(Long id) {
        User user = userRepository.findById(id).get();
        if (user.getStatus() == AccountStatus.ENABLED) {
            user.setStatus(AccountStatus.DISABLED);
        } else {
            user.setStatus(AccountStatus.ENABLED);
        }
        userRepository.save(user);
    }

    public void deleteEmployee(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public void addEmployee(User user) {
        user.setStatus(AccountStatus.ENABLED);
        user.setRoles(setRole(2L));
        userRepository.save(user);
    }

    public List<Role> setRole(Long roleId) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(roleId);
        roles.add(role);
        return roles;
    }
}
