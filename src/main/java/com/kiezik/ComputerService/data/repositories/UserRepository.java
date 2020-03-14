package com.kiezik.ComputerService.data.repositories;

import com.kiezik.ComputerService.data.model.Role;
import com.kiezik.ComputerService.data.model.User;
import com.kiezik.ComputerService.enums.AccountStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAllByRoles_Id(Long role);

    List<User> findAllByRoles_IdAndStatus(Long role, AccountStatus status);
}
