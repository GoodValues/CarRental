package com.springteam.carrental.model.repository;

import com.springteam.carrental.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
