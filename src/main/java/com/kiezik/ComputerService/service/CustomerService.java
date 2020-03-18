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

@Service
@Transactional
public class CustomerService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getCustomers() {
        List<User> customersList = userRepository.findAllByRoles_Id(3L);
        return customersList;
    }

    public User getCustomer(Long customerId) {
        User user = userRepository.findById(customerId).get();
        return user;
    }

    public User getCustomerByEmail(String customerEmail) {
        User user = userRepository.findByEmail(customerEmail).get();
        return user;
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

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public void addUser(User user) {
        user.setStatus(AccountStatus.ENABLED);
        user.setRoles(setRole(3L));
        userRepository.save(user);
    }

    public Long addUserGetId(User user) {
        if (user.getId() == null) {
            user.setStatus(AccountStatus.ENABLED);
            user.setRoles(setRole(3L));
            return userRepository.save(user).getId();
        } else
            return user.getId();

    }

    public List<Role> setRole(Long roleId) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(roleId);
        roles.add(role);
        return roles;
    }
}
