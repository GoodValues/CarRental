package com.springteam.carrental.model.repository;

import com.springteam.carrental.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {
}
