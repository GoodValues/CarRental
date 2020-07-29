package com.springteam.carrental.controllers;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.dto.RentalStatus;
import com.springteam.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<CarDTO> cars = carService.getAllCars();
        model.addAttribute("carsList", cars);
        return "cars";
    }

    @PostMapping("/getCarsForBranch")
    public String getCarsForBranch(Model model, @RequestParam String branch) {
        List<CarDTO> cars = carService.getCarsForBranch(branch);
        if(branch==null) cars = carService.getAllCars();
        model.addAttribute("carsList", cars);
        return "cars";
    }

    @GetMapping("/addCar")
    public String addCar(Model model) {
        List<String> statuses = new ArrayList<>();
        for(RentalStatus rentalStatus : RentalStatus.values()) {
            statuses.add(rentalStatus.name());
        }
        model.addAttribute("statuses", statuses);
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addingCar(CarDTO carDTO) {
        carService.saveCar(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/editCar")
    public String editCar(Model model, @RequestParam Long id) {
        CarDTO carDTO = carService.getCarById(id);
        model.addAttribute("car", carDTO);
        return "editCar";
    }

    @PutMapping("/editCar")
    public String saveEditedCar(CarDTO carDTO) {
        carService.saveCar(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/deleteCar")
    public String deleteCar(@RequestParam Long id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

}
