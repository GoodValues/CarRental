package com.springteam.carrental.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Returning {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    private LocalDateTime returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    private BigDecimal surcharge;  //nadpłata
    private String comment;
}
