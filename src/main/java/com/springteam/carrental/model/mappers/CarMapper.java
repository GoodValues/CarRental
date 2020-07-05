package com.springteam.carrental.model.mappers;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    static CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carToDto(Car car);
    Car dtoToCar(CarDTO carDTO);
}
