package com.javaclass.anatolianweb.controllers;

import com.javaclass.anatolianweb.model.Comment;
import com.javaclass.anatolianweb.model.Destination;
import com.javaclass.anatolianweb.repos.CommentRepository;
import com.javaclass.anatolianweb.repos.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    // Create
    @PostMapping(value = "/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    // Read
    @GetMapping(value = "/allComments")
    public @ResponseBody
    Iterable<Comment> getAll() {
        return commentRepository.findAll();
    }

    // Update
    @PutMapping(value = "/updateComment/{id}")
    public Comment updateComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));
        existingComment.setCommentText(comment.getCommentText());
        return commentRepository.save(existingComment);
    }

    // Delete
    @DeleteMapping(value = "/deleteComment/{id}")
    public void deleteComment(@PathVariable("id") Integer id) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));
        commentRepository.delete(existingComment);
    }
}
