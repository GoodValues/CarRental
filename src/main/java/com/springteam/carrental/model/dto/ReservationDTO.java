package com.springteam.carrental.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {

    private Long id;
    private LocalDateTime rentalDate;
    private UserDTO client;
    private CarDTO car;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private BranchDTO rentalBranch;
    private BranchDTO returnBranch;
    private BigDecimal totalPrice;



}
