package com.softwareEngineering.mdmatravelbackend.controllers;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterRateDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Rate;
import com.softwareEngineering.mdmatravelbackend.services.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/rate")
@RequiredArgsConstructor

public class RateController {

    private final RateService rateService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Rate> getAll(){
        return rateService.getAllRate();
    }

    @GetMapping("/getAvarageByRestaurantID/{id}")
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

    @PostMapping("/addRate")
    @ResponseStatus(HttpStatus.OK)
    public Rate register(@RequestBody RegisterRateDto rateRegisterDto) {
        return rateService.registerRate(rateRegisterDto);
    }

}
