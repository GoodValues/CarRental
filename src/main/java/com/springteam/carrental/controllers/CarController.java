package com.springteam.carrental.controllers;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addCar")
    public String addCar() {
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
        return "redirect:/editCar";
    }

    @PutMapping("/editCar")
    public String saveEditedCar(CarDTO carDTO) {
        carService.saveCar(carDTO);
        return "redirect:/cars";
    }

    @DeleteMapping("/deleteCar")
    public String deleteCar(@RequestParam Long id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

}
