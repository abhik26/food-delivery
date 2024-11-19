package abhik26.food_delivery.food_order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhik26.food_delivery.food_order.dto.OrderDto;
import abhik26.food_delivery.food_order.dto.OrderDtoFromUI;
import abhik26.food_delivery.food_order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDtoFromUI orderToCreate) {
        OrderDto createdOrder = orderService.saveOrder(orderToCreate);
        return new ResponseEntity<OrderDto>(createdOrder, HttpStatus.CREATED);
    }
}
