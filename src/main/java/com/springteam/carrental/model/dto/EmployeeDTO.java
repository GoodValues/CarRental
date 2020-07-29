package com.springteam.carrental.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
    private BranchDTO branchDTO;
}
