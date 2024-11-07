package abhik26.food_delivery.restaurant_listing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhik26.food_delivery.restaurant_listing.dto.RestaurantDTO;
import abhik26.food_delivery.restaurant_listing.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurantDTOs = restaurantService.getAllRestaurants();
        ResponseEntity<List<RestaurantDTO>> response = new ResponseEntity<List<RestaurantDTO>>(restaurantDTOs,
                HttpStatus.OK);
        return response;
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestarurant(@RequestBody RestaurantDTO restaurantToAdd) {
        System.out.println(restaurantToAdd.toString());
        RestaurantDTO addedRestaurant = restaurantService.addRestaurant(restaurantToAdd);
        return new ResponseEntity<RestaurantDTO>(addedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer id) {
        RestaurantDTO restaurantById = restaurantService.getRestaurantById(id);
        
        if (restaurantById != null) {
            return new ResponseEntity<RestaurantDTO>(restaurantById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
