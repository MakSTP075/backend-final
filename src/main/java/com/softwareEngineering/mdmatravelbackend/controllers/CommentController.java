package com.softwareEngineering.mdmatravelbackend.controllers;

import com.softwareEngineering.mdmatravelbackend.data.models.Comment;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentDto;
import com.softwareEngineering.mdmatravelbackend.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Comment> getAll(){
        return commentService.getAllComment();
    }


    @PostMapping("/addComment")
    @ResponseStatus(HttpStatus.OK)
    public Comment register(@RequestBody RegisterCommentDto commentRegisterDto) {
        return commentService.registerComment(commentRegisterDto);
    }
}
