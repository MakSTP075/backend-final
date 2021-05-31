package com.softwareEngineering.mdmatravelbackend.controllers;
import com.softwareEngineering.mdmatravelbackend.data.models.Siteview;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterSiteviewDto;
import com.softwareEngineering.mdmatravelbackend.services.SiteviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/siteviews")
@RequiredArgsConstructor

public class SiteviewController {

    private final SiteviewService siteviewService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Siteview> getAll(){
        return siteviewService.getAllSiteview();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Siteview findById(@RequestBody int id){
        return siteviewService.getSiteviewById(id);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody long id){
        try{
            siteviewService.deleteSiteviewById(id);
            System.out.println("Successfully deleted Siteview");}
        catch(Exception ex){
            System.out.println(ex);
        }
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Siteview putById(@RequestBody Siteview siteview){
        return siteviewService.putSiteviewById(siteview);
    }


    @PostMapping("/addSiteview")
    @ResponseStatus(HttpStatus.OK)
    public Siteview register(@RequestBody RegisterSiteviewDto siteviewRegisterDto) {
        return siteviewService.registerSiteview(siteviewRegisterDto);
    }
}
