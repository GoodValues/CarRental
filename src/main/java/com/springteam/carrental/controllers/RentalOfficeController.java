package com.springteam.carrental.controllers;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.dto.RentalOfficeDTO;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.services.RentalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("office")
public class RentalOfficeController {

    RentalOfficeService rentalOfficeService;

    @Autowired
    public RentalOfficeController(RentalOfficeService rentalOfficeService) {
        this.rentalOfficeService = rentalOfficeService;
    }

    @GetMapping("/offices")
    public String getAllOffices(Model model) {
        List<RentalOfficeDTO> offices = rentalOfficeService.getAllOffices();
        model.addAttribute("officesList", offices);
        return "offices";
    }

    @GetMapping("/getAllBranches/{id}")
    public String getAllBranches(Model model, @PathVariable Long id) {
        List<BranchDTO> branches = rentalOfficeService.getAllBranchesForOfficeWithId(id);
        model.addAttribute("branchesList", branches);
        return "branches";
    }

    @GetMapping("/addRentalOffice")
    public String addRentalOffice() {
        return "addOffice";
    }

    @PostMapping("/addRentalOffice")
    public String addRentalOffice(RentalOfficeDTO rentalOfficeDTO) {
        rentalOfficeService.saveRentalOffice(rentalOfficeDTO);
        return "redirect:/offices";
    }

    @GetMapping("/editOffice")
    public String updateData(Model model, @RequestParam Long id) {
        RentalOfficeDTO rentalOfficeDTO = rentalOfficeService.getOfficeById(id);
        model.addAttribute("rentalOffice", rentalOfficeDTO);
        return "editOffice";
    }

    @PostMapping("/editOffice")
    public String updateData(RentalOfficeDTO rentalOfficeDTO) {
        rentalOfficeService.saveRentalOffice(rentalOfficeDTO);
        return "redirect:/offices";
    }

    @PostMapping(value = "/chooseOffice")
    public String postLogin(Model model, @ModelAttribute("office") RentalOfficeDTO rentalOfficeDTO) {
        model.addAttribute("office", rentalOfficeDTO);
        return "redirect:/login";
    }

    @GetMapping("/deleteOffice")
    public String deleteCar(@RequestParam Long id) {
        rentalOfficeService.deleteOfficeById(id);
        return "redirect:/offices";
    }
}
