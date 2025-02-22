package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Forum;
import com.javaclass.anatolianweb.model.Manager;
import com.javaclass.anatolianweb.repos.ForumRepository;
import com.javaclass.anatolianweb.repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumRepository forumRepository;

    // CREATE
    @PostMapping(value = "/createForum")
    public Forum createForum(@RequestBody Forum forum) {
        return forumRepository.save(forum);
    }

    // READ
    @GetMapping(value = "/allForums")
    public @ResponseBody Iterable<Forum> getAll() {
        return forumRepository.findAll();
    }

    // UPDATE/EDIT
    @PutMapping(value = "/editForum/{id}")
    public Forum editForum(@PathVariable("id") Integer id, @RequestBody Forum forum) {
        Optional<Forum> existingForum = forumRepository.findById(id);
        if (existingForum.isPresent()) {
            Forum forumToUpdate = existingForum.get();
            forumToUpdate.setTitle(forum.getTitle());

            return forumRepository.save(forumToUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Forum not found");
        }
    }

    // DELETE
    @DeleteMapping(value = "/deleteForum/{id}")
    public void deleteForum(@PathVariable("id") Integer id) {
        Optional<Forum> existingForum = forumRepository.findById(id);
        if (existingForum.isPresent()) {
            forumRepository.delete(existingForum.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Forum not found");
        }
    }
}
