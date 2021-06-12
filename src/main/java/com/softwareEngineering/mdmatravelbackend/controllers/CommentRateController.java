package com.softwareEngineering.mdmatravelbackend.controllers;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import com.softwareEngineering.mdmatravelbackend.services.CommentRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CommentRate")
@RequiredArgsConstructor

public class CommentRateController {

    private final CommentRateService commentRateService;

    @GetMapping("/getAllCommentRateByHistoricID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentRate> getAllByHistoricID(@PathVariable long id){
        return commentRateService.getAllCommentAndRateByHistoricId(id);
    }

    @GetMapping("/getAllCommentRateByRestaurantID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentRate> getAllByRestaurantID(@PathVariable long id){
        return commentRateService.getAllCommentAndRateByRestaurantId(id);
    }

    @GetMapping("/getAllCommentRateBySiteviewID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentRate> getAllBySiteviewID(@PathVariable long id){
        return commentRateService.getAllCommentAndRateBySiteviewId(id);
    }

    @PostMapping("/addCommentAndRate")
    @ResponseStatus(HttpStatus.OK)
    public CommentRate register(@RequestBody RegisterCommentRateDto commentRateRegisterDto) {
        return commentRateService.registerCommentRate(commentRateRegisterDto);
    }
}

