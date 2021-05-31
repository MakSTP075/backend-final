package com.softwareEngineering.mdmatravelbackend.controllers;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterHistoricDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import com.softwareEngineering.mdmatravelbackend.services.HistoricService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/historics")
@RequiredArgsConstructor

public class HistoricController {

    private final HistoricService historicService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Historic> getAll(){
        return historicService.getAllHistoric();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Historic findById(@RequestBody int id){
        return historicService.getHistoricById(id);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody long id){
        try{
            historicService.deleteHistoricById(id);
            System.out.println("Successfully deleted Historic");}
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Historic putById(@RequestBody Historic historic){
       return historicService.putHistoricById(historic);
    }

    @PostMapping("/addHistoric")
    @ResponseStatus(HttpStatus.OK)
    public Historic register(@RequestBody RegisterHistoricDto historicRegisterDto) {
        return historicService.registerHistoric(historicRegisterDto);
    }
}
