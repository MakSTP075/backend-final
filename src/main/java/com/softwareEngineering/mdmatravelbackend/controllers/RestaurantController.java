package com.softwareEngineering.mdmatravelbackend.controllers;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterRestaurantDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Restaurant;
import com.softwareEngineering.mdmatravelbackend.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Restaurant> getAll(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant findById(@PathVariable int id){
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable long id){
        try{
            restaurantService.deleteRestaurantById(id);
            System.out.println("Successfully deleted Restaurant");}
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant putById(@RequestBody Restaurant restaurant){
        return restaurantService.putRestaurantById(restaurant);
    }


    @PostMapping("/addRestaurant")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant register(@RequestBody RegisterRestaurantDto restaurantRegisterDto) {
        return restaurantService.registerRestaurant(restaurantRegisterDto);
    }
}
