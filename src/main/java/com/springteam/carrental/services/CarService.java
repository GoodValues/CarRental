package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.entity.Car;
import com.springteam.carrental.model.mappers.CarMapper;
import com.springteam.carrental.model.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    CarRepo carRepo;
    BranchService branchService;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepo.findAll();
        List<CarDTO> result = new ArrayList<>();
        for (Car car : cars)
            result.add(CarMapper.INSTANCE.carToDto(car));
        return result;
    }

    public List<CarDTO> getCarsForBranch(String address) {
        List<CarDTO> cars = branchService.getBranchByAddress(address).getCars();
        return cars;
    }

    public void saveCar(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.dtoToCar(carDTO);
        carRepo.save(car);
    }

    public CarDTO getCarById(Long id) {
        Optional<Car> car = carRepo.findById(id);
        return car.map(CarMapper.INSTANCE::carToDto).orElse(null);
    }

    public void deleteCarById(Long id) {
        carRepo.deleteById(id);
    }
}
