package abhik26.food_delivery.food_order.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import abhik26.food_delivery.food_order.dto.OrderDto;
import abhik26.food_delivery.food_order.dto.OrderDtoFromUI;
import abhik26.food_delivery.food_order.dto.UserDto;
import abhik26.food_delivery.food_order.entity.Order;
import abhik26.food_delivery.food_order.mapper.OrderMapper;
import abhik26.food_delivery.food_order.repo.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private SequenceGenerator sequenceGenerator;
    private RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, SequenceGenerator sequenceGenerator,
            RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.sequenceGenerator = sequenceGenerator;
        this.restTemplate = restTemplate;
    }

    public OrderDto saveOrder(OrderDtoFromUI orderToCreate) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDto user = fetchUserFromUserId(orderToCreate.getUserId());
        
        Order orderToBeSaved = new Order(newOrderId, orderToCreate.getFoodItems(), orderToCreate.getRestaurant(), user);
        orderRepository.save(orderToBeSaved);

        return OrderMapper.INSTACE.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDto fetchUserFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-INFO/users/{id}", UserDto.class, userId);
    }
}
