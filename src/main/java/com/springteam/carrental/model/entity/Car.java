package com.springteam.carrental.model.entity;

import com.springteam.carrental.model.dto.RentalStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String model;
    private String bodyType;
    private Integer productionYear;
    private String color;
    private Long mileage;

    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    private BigDecimal priceForDay;
}
