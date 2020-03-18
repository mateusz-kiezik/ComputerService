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

    public User getCustomerByUsername(String customerUsername) {
        User user = userRepository.findByEmail(customerUsername).get();
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

    public void editUser(User customer) {
        User currentCustomer = userRepository.findById(customer.getId()).get();
        customer.setStatus(currentCustomer.getStatus());
        customer.setRoles(currentCustomer.getRoles());
        userRepository.save(customer);
    }

    public Long addUserGetId(User customer) {
        if (customer.getId() == null) {
            customer.setStatus(AccountStatus.ENABLED);
            customer.setRoles(setRole(3L));
            return userRepository.save(customer).getId();
        } else if (customer.getStatus() == null) {
            User currentCustomer = userRepository.findById(customer.getId()).get();
            customer.setStatus(currentCustomer.getStatus());
            customer.setRoles(currentCustomer.getRoles());
            return userRepository.save(customer).getId();
        } else
            return customer.getId();
    }


    public List<Role> setRole(Long roleId) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(roleId);
        roles.add(role);
        return roles;
    }
}
