package com.springteam.carrental.model.repository;


import com.springteam.carrental.model.entity.Returning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepo extends JpaRepository<Returning, Long> {
}
