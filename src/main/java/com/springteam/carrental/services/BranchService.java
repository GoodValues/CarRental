package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.entity.Branch;
import com.springteam.carrental.model.mappers.BranchMapper;
import com.springteam.carrental.model.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    BranchRepo branchRepo;

    @Autowired
    public BranchService(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    public List<BranchDTO> getAllBranches() {
        List<Branch> branches = branchRepo.findAll();
        List<BranchDTO> result = new ArrayList<>();
        for (Branch branch : branches)
            result.add(BranchMapper.INSTANCE.branchToDto(branch));
        return result;
    }

    public void saveBranch(BranchDTO branchDTO) {
        Branch branch = BranchMapper.INSTANCE.dtoToBranch(branchDTO);
        branchRepo.save(branch);
    }

    public BranchDTO getBranchById(Long id) {
        Optional<Branch> branch = branchRepo.findById(id);
        return branch.map(BranchMapper.INSTANCE::branchToDto).orElse(null);
    }

    public void deleteBranchById(Long id) {
        branchRepo.deleteById(id);
    }
}
