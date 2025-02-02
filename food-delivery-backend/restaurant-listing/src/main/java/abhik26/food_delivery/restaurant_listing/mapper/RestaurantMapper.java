package abhik26.food_delivery.restaurant_listing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import abhik26.food_delivery.restaurant_listing.dto.RestaurantDto;
import abhik26.food_delivery.restaurant_listing.entity.Restaurant;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
}
