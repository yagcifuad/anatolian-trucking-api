package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Checkpoint;
import com.javaclass.anatolianweb.model.Comment;
import com.javaclass.anatolianweb.repos.CheckpointRepository;
import com.javaclass.anatolianweb.repos.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/checkpoint")
public class CheckpointController {

    @Autowired
    private CheckpointRepository checkpointRepository;

    @GetMapping(value = "/allCheckpoints")
    public @ResponseBody
    Iterable<Checkpoint> getAll() {
        return checkpointRepository.findAll(); //Read
    }

    @PostMapping(value = "/createCheckpoint")
    public @ResponseBody
    Checkpoint createCheckpoint(@RequestBody Checkpoint checkpoint) {
        return checkpointRepository.save(checkpoint); // Create
    }

    @PutMapping(value = "/updateCheckpoint/{id}")
    public @ResponseBody
    Checkpoint updateCheckpoint(@PathVariable("id") Integer id, @RequestBody Checkpoint checkpoint) {
        Checkpoint existingCheckpoint = checkpointRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checkpoint not found"));
        existingCheckpoint.setTitle(checkpoint.getTitle());
        existingCheckpoint.setDateArrived(checkpoint.getDateArrived());
        return checkpointRepository.save(existingCheckpoint); // Update
    }

    @DeleteMapping(value = "/deleteCheckpoint/{id}")
    public void deleteCheckpoint(@PathVariable Integer id) {
        Checkpoint existingCheckpoint = checkpointRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checkpoint not found"));
        checkpointRepository.delete(existingCheckpoint); // Delete
    }
}
