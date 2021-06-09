package com.softwareEngineering.mdmatravelbackend.controllers;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import com.softwareEngineering.mdmatravelbackend.services.CommentRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/CommentRate")
@RequiredArgsConstructor

public class CommentRateController {

    private final CommentRateService commentRateService;

    @GetMapping("/getAllCommentRateByHistoricID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentRate> getAllByHistoricID(@PathVariable long id){
        return commentRateService.getAllCommentRateByHistoricID(id);
    }

    @GetMapping("/getAllCommentRateByRestaurantID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentRate> getAllByRestaurantID(@PathVariable long id){
        return commentRateService.getAllCommentByRestaurantID(id);
    }

    @GetMapping("/getAllCommentRateBySiteviewID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentRate> getAllBySiteviewID(@PathVariable long id){
        return commentRateService.getAllCommentBySiteviewID(id);
    }

    @PostMapping("/addCommentAndRate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentRate register(@RequestBody RegisterCommentRateDto commentRateRegisterDto) {
        return commentRateService.registerCommentRate(commentRateRegisterDto);
    }
}



/*   @GetMapping("/getAvarageByRestaurantID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double getAvarageRestaurantRate(@PathVariable long id){
        return rateService.avarageRestaurantRate(id);
    }

    @GetMapping("/getAvarageByHistoricID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double getAvarageHistoricRate(@PathVariable long id){
        return rateService.avarageHistoricRate(id);
    }

    @GetMapping("/getAvarageBySiteviewID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double getAvarageSiteviewRate(@PathVariable long id){
        return rateService.avarageSiteviewRate(id);
    }
*/
