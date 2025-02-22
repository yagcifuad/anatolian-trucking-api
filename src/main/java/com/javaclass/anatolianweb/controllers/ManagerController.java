package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Manager;
import com.javaclass.anatolianweb.repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerRepo managerRepo;

    @GetMapping(value = "/allManagers")
    public @ResponseBody Iterable<Manager> getAll() {
        return managerRepo.findAll(); // Read
    }

    @PostMapping(value = "/createManager")
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepo.save(manager); // Create
    }

    @PutMapping(value = "/{id}")
    public Manager updateManager(@PathVariable Integer id, @RequestBody Manager manager) {
        Manager existingManager = managerRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager not found"));
        existingManager.setName(manager.getName());
        existingManager.setEmail(manager.getEmail());
        ///update later
        return managerRepo.save(existingManager); // Update
    }

    @DeleteMapping(value = "/{id}")
    public void deleteManager(@PathVariable Integer id) {
        Manager existingManager = managerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager not found"));
        managerRepo.delete(existingManager); // Delete
    }
}
