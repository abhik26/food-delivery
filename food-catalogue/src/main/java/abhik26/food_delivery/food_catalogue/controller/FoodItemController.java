package abhik26.food_delivery.food_catalogue.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhik26.food_delivery.food_catalogue.dto.FoodCatalogueDto;
import abhik26.food_delivery.food_catalogue.dto.FoodItemDto;
import abhik26.food_delivery.food_catalogue.service.FoodItemService;

@RestController
@RequestMapping("/food-catalogues")
public class FoodItemController {

    private FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping
    public ResponseEntity<FoodItemDto> registerFoodItem(@RequestBody FoodItemDto foodItemToAdd) {
        FoodItemDto addedFoodItem = foodItemService.addFoodItem(foodItemToAdd);
        System.out.println("\n\n" + foodItemToAdd + "\n\n");
        return new ResponseEntity<FoodItemDto>(addedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<FoodCatalogueDto> getRestaurantDetailsWithFoodItem(@PathVariable Integer restaurantId) {
        FoodCatalogueDto foodCatalogue = foodItemService.getFoodCatalogueByRestaurantId(restaurantId);
        
        if (foodCatalogue != null) {
            return new ResponseEntity<FoodCatalogueDto>(foodCatalogue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
