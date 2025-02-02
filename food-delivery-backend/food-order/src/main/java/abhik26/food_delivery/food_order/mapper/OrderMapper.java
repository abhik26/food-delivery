package abhik26.food_delivery.food_order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import abhik26.food_delivery.food_order.dto.OrderDto;
import abhik26.food_delivery.food_order.entity.Order;

@Mapper
public interface OrderMapper {
    public OrderMapper INSTACE = Mappers.getMapper(OrderMapper.class);

    OrderDto mapOrderToOrderDto(Order order);
    Order mapOrderDtoToOrder(OrderDto orderDto);
}
