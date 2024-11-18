package abhik26.food_delivery.food_catalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import abhik26.food_delivery.food_catalogue.dto.FoodItemDto;
import abhik26.food_delivery.food_catalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);
}
