package abhik26.food_delivery.food_order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import abhik26.food_delivery.food_order.dto.FoodItemDto;
import abhik26.food_delivery.food_order.dto.RestaurantDto;
import abhik26.food_delivery.food_order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
    private Integer id;
    private List<FoodItemDto> foodItems;
    private RestaurantDto restaurant;
    private UserDto user;
}
