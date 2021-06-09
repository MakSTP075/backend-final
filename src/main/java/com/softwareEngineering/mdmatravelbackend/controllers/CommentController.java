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

    @GetMapping("/getAllByHistoricID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllByHistoricID(@PathVariable long id){
        return commentService.getAllCommentByHistoricID(id);
    }

    @GetMapping("/getAllByRestaurantID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllByRestaurantID(@PathVariable long id){
        return commentService.getAllCommentByRestaurantID(id);
    }

    @GetMapping("/getAllBySiteviewID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllBySiteviewID(@PathVariable long id){
        return commentService.getAllCommentBySiteviewID(id);
    }



    @PostMapping("/addComment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment register(@RequestBody RegisterCommentDto commentRegisterDto) {
        return commentService.registerComment(commentRegisterDto);
    }
}
