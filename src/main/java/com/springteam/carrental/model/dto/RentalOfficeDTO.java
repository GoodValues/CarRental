package com.springteam.carrental.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RentalOfficeDTO {

    private String name;
    private String webPage;
    private String address;
    private String owner;
    private String logotype;
    private List<BranchDTO> branches;

}
