package com.javaclass.anatolianweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;
    private double weight;
    @Enumerated
    private CargoType cargoType;
    private String description;
    private String customer;

    @JsonIgnore
    @OneToOne(orphanRemoval = true)
    private Destination currentDestination;


    public Cargo(String title, LocalDate dateCreated, LocalDate dateUpdated, double weight, CargoType cargoType, String description, String customer, Destination currentDestination) {
        this.title = title;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.weight = weight;
        this.cargoType = cargoType;
        this.description = description;
        this.customer = customer;
        this.currentDestination = currentDestination;
    }

    public Cargo(String title, double weight, CargoType cargoType, String description, String customer) {
        this.title = title;
        this.weight = weight;
        this.cargoType = cargoType;
        this.description = description;
        this.customer = customer;
        this.dateCreated= LocalDate.now();

    }

    @Override
    public String toString() {
        return "("+id+")  "+ title ;
    }
}
