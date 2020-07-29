package com.springteam.carrental.model.repository;

import com.springteam.carrental.model.entity.RentalOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalOfficeRepo extends JpaRepository<RentalOffice, Long> {
    RentalOffice findByName(String name);
}
