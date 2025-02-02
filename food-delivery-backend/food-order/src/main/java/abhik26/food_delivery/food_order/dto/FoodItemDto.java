package abhik26.food_delivery.food_order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDto {

    private Integer id;
    private String name;
    private String description;
    private Boolean veg;
    private Number price;
    private Integer restaurantId;
    private Integer quantity;
}
