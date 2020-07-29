package com.springteam.carrental.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReturnDTO {

    private Long id;
    private EmployeeDTO employee;
    private LocalDateTime returnDate;
    private ReservationDTO reservation;
    private BigDecimal surcharge;  //nadpłata
    private String comment;
}
