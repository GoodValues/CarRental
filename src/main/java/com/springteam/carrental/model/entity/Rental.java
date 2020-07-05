package com.springteam.carrental.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    private LocalDateTime rentalDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    private String comment;


}
