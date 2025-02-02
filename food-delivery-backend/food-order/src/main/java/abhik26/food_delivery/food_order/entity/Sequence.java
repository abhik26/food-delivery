package abhik26.food_delivery.food_order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
    @Id
    private String id;
    private  Integer sequence;
}
