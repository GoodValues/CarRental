package com.springteam.carrental.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {

    private Date rentalDate;
    private ClientDTO client;
    private CarDTO car;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private BranchDTO rentalBranch;
    private BranchDTO returnBranch;
    private BigDecimal totalPrice;



}
