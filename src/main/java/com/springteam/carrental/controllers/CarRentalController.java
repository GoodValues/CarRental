package com.springteam.carrental.controllers;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carRental")
public class CarRentalController {

    BranchService branchService;

    @Autowired
    public CarRentalController(BranchService branchService) {
        this.branchService=branchService;
    }

    @GetMapping("/getAllBranches")
    public String getAllBranches(Model model) {
        List<BranchDTO> branches = branchService.getAllBranches();
        model.addAttribute("branchesList", branches);
        return "branches";
    }
}
