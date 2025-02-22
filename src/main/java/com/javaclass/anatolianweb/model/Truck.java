package com.javaclass.anatolianweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private String model;
    private int year;
    private double odometer;
    private double fuelTankCapacity;
    private TyreType tyreType;

    @JsonIgnore
    @OneToOne(orphanRemoval = true)
    private Destination currentDestination;

    public Truck(String make, String model, int year, double odometer, double fuelTankCapacity, TyreType tyreType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = odometer;
        this.fuelTankCapacity = fuelTankCapacity;
        this.tyreType = tyreType;
    }

    @Override
    public String toString() {
        return "("+id+")  "+ model ;
    }
}
