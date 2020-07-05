package com.springteam.carrental.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
