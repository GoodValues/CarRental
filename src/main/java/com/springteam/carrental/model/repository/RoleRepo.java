package com.springteam.carrental.model.repository;

import com.springteam.carrental.model.entity.Role;
import com.springteam.carrental.model.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
