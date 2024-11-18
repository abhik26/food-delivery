package abhik26.food_delivery.food_catalogue.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogueDto {

    private List<FoodItemDto> foodItems;
    private RestaurantDto restaurant;
}
