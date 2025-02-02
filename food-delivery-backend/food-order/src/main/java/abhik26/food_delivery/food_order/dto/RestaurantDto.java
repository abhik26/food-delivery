package abhik26.food_delivery.food_order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String description;
}
