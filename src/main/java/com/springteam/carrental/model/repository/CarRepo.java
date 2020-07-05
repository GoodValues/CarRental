package com.springteam.carrental.model.repository;

import com.springteam.carrental.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}
