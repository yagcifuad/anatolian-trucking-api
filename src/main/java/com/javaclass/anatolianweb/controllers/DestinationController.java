package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Destination;
import com.javaclass.anatolianweb.model.Driver;
import com.javaclass.anatolianweb.repos.DestinationRepository;
import com.javaclass.anatolianweb.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/destination")
public class DestinationController {
    @Autowired
    private DestinationRepository destinationRepository;

    // Create
    @PostMapping(value = "/addDestination")
    public Destination addDestination(@RequestBody Destination destination) {
        return destinationRepository.save(destination);
    }

    // Read
    @GetMapping(value = "/allDestinations")
    public @ResponseBody
    Iterable<Destination> getAll() {
        return destinationRepository.findAll();
    }

    // Update
    @PutMapping(value = "/updateDestination/{id}")
    public Destination updateDestination(@PathVariable("id") Integer id, @RequestBody Destination destination) {
        Destination existingDestination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination not found"));
        existingDestination.setCargo(destination.getCargo());
        existingDestination.setDriver(destination.getDriver());
        existingDestination.setStartCity(destination.getStartCity());
        existingDestination.setEndCity(destination.getEndCity());
        ///later others I will add
        return destinationRepository.save(existingDestination);
    }

    // Delete
    @DeleteMapping(value = "/deleteDestination/{id}")
    public void deleteDestination(@PathVariable("id") Integer id) {
        Destination existingDestination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination not found"));
        destinationRepository.delete(existingDestination);
    }
}

