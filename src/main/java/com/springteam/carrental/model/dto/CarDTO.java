package com.springteam.carrental.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private Integer productionYear;
    private String color;
    private Long mileage;
    private RentalStatus rentalStatus;
    private BigDecimal priceForDay;
}
