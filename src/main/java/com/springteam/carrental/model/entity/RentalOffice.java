package com.springteam.carrental.model.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class RentalOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String webPage;
    private String address;
    private String owner;
    private String logotype;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Branch> branches;

    public RentalOffice(String name, String webPage, String address, String owner, String logotype) {
        this.name = name;
        this.webPage = webPage;
        this.address = address;
        this.owner = owner;
        this.logotype = logotype;
    }
}
