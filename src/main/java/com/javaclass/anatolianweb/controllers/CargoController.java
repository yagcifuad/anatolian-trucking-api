package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Cargo;
import com.javaclass.anatolianweb.model.Checkpoint;
import com.javaclass.anatolianweb.repos.CargoRepository;
import com.javaclass.anatolianweb.repos.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping(value = "/allCargos")
    public @ResponseBody
    Iterable<Cargo> getAll() {
        return cargoRepository.findAll(); //Read
    }

    @PostMapping(value = "/createCargo")
    public @ResponseBody
    Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo); // Create
    }

    @PutMapping(value = "/updateCargo/{id}")
    public @ResponseBody
    Cargo updateCargo(@PathVariable("id") Integer id, @RequestBody Cargo cargo) {
        Cargo existingCargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo not found"));
        existingCargo.setTitle(cargo.getTitle());
        existingCargo.setDescription(cargo.getDescription());
        existingCargo.setCargoType(cargo.getCargoType());
        existingCargo.setCustomer(cargo.getCustomer());
        //later I will add more
        return cargoRepository.save(existingCargo); // Update
    }

    @DeleteMapping(value = "/deleteCargo/{id}")
    public void deleteCargo(@PathVariable Integer id) {
        Cargo existingCargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo not found"));
        cargoRepository.delete(existingCargo); // Delete
    }
}
