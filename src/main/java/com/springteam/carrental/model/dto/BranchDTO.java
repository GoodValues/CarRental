package com.springteam.carrental.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BranchDTO {

    private Long id;
    private String address;
    private List<EmployeeDTO> employees;
    private List<CarDTO> cars;
}
