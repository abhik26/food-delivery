package abhik26.food_delivery.food_order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import abhik26.food_delivery.food_order.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {


}
