package com.springteam.carrental.model.repository;


import com.springteam.carrental.model.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Long> {
}
