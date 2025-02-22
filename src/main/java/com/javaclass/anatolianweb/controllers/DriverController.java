package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Driver;
import com.javaclass.anatolianweb.model.User;
import com.javaclass.anatolianweb.repos.DriverRepo;
import com.javaclass.anatolianweb.repos.ManagerRepo;
import com.javaclass.anatolianweb.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverRepo driverRepository;

    @GetMapping(value = "/allDrivers")
    public @ResponseBody Iterable<Driver> getAll() {
        return driverRepository.findAll(); // Read
    }

    @PostMapping(value = "")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver); // Create
    }

    @PutMapping(value = "/{id}")
    public Driver updateDriver(@PathVariable Integer id, @RequestBody Driver driver) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found"));
        existingDriver.setName(driver.getName());
        existingDriver.setPassword(driver.getPassword());
        existingDriver.setDriverLicense(driver.getDriverLicense());
        existingDriver.setMedCertificateDate(driver.getMedCertificateDate());
        existingDriver.setMedCertificateNumber(driver.getMedCertificateNumber());
        existingDriver.setLogin(driver.getLogin());
        //....... etc. I can add later

        return driverRepository.save(existingDriver); // Update
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDriver(@PathVariable Integer id) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found"));
        driverRepository.delete(existingDriver); // Delete
    }
}

