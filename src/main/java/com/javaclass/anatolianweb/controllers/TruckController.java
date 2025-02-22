package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Cargo;
import com.javaclass.anatolianweb.model.Truck;
import com.javaclass.anatolianweb.repos.CargoRepository;
import com.javaclass.anatolianweb.repos.TruckRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/truck")
public class TruckController {
    @Autowired
    private TruckRepository truckRepository;

    // CREATE
    @PostMapping(value = "/createTruck")
    public Truck createTruck(@RequestBody Truck truck) {
        return truckRepository.save(truck);
    }

    // READ
    @GetMapping(value = "/allTrucks")
    public @ResponseBody Iterable<Truck> getAll() {
        return truckRepository.findAll();
    }

    // UPDATE/EDIT
    @PutMapping(value = "/editTruck/{id}")
    public Truck editTruck(@PathVariable("id") Integer id, @RequestBody Truck truck) {
        Optional<Truck> existingTruck = truckRepository.findById(id);
        if (existingTruck.isPresent()) {
            Truck truckToUpdate = existingTruck.get();
            truckToUpdate.setModel(truck.getModel());
            truckToUpdate.setMake(truck.getMake());
            truckToUpdate.setOdometer(truck.getOdometer());
            truckToUpdate.setTyreType(truck.getTyreType());
            truckToUpdate.setFuelTankCapacity(truck.getFuelTankCapacity());
            //others later I will add
            return truckRepository.save(truckToUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Truck not found");
        }
    }

    // DELETE
    @DeleteMapping(value = "/deleteTruck/{id}")
    public void deleteTruck(@PathVariable("id") Integer id) {
        Optional<Truck> existingTruck = truckRepository.findById(id);
        if (existingTruck.isPresent()) {
            truckRepository.delete(existingTruck.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Truck not found");
        }
    }
}

