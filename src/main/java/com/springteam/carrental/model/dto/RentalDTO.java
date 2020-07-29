package com.springteam.carrental.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RentalDTO {

    private Long id;
    private EmployeeDTO employee;
    private LocalDateTime rentalDate;
    private ReservationDTO reservation;
    private String comment;
}
