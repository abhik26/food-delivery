package abhik26.food_delivery.restaurant_listing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhik26.food_delivery.restaurant_listing.dto.RestaurantDto;
import abhik26.food_delivery.restaurant_listing.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> restaurantDTOs = restaurantService.getAllRestaurants();
        ResponseEntity<List<RestaurantDto>> response = new ResponseEntity<List<RestaurantDto>>(restaurantDTOs,
                HttpStatus.OK);
        return response;
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> addRestarurant(@RequestBody RestaurantDto restaurantToAdd) {
        RestaurantDto addedRestaurant = restaurantService.addRestaurant(restaurantToAdd);
        return new ResponseEntity<RestaurantDto>(addedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Integer id) {
        RestaurantDto restaurantById = restaurantService.getRestaurantById(id);
        
        if (restaurantById != null) {
            return new ResponseEntity<RestaurantDto>(restaurantById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
