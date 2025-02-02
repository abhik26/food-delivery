package abhik26.food_delivery.food_order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromUI {

    private List<FoodItemDto> foodItems;
    private Integer userId;
    private RestaurantDto restaurant;
}
