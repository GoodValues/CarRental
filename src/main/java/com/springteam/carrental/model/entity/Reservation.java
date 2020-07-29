package com.springteam.carrental.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime rentalDate;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    @OneToOne(cascade = CascadeType.ALL)
    private Branch rentalBranch;

    @OneToOne(cascade = CascadeType.ALL)
    private Branch returnBranch;

    private BigDecimal totalPrice;



}
