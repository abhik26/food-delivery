package abhik26.food_delivery.food_catalogue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import abhik26.food_delivery.food_catalogue.dto.FoodCatalogueDto;
import abhik26.food_delivery.food_catalogue.dto.FoodItemDto;
import abhik26.food_delivery.food_catalogue.dto.RestaurantDto;
import abhik26.food_delivery.food_catalogue.entity.FoodItem;
import abhik26.food_delivery.food_catalogue.mapper.FoodItemMapper;
import abhik26.food_delivery.food_catalogue.repo.FoodItemRepository;

@Service
public class FoodItemService {

    private FoodItemRepository foodItemRepository;
    private RestTemplate restTemplate;

    public FoodItemService(FoodItemRepository foodItemRepository, RestTemplate restTemplate) {
        this.foodItemRepository = foodItemRepository;
        this.restTemplate = restTemplate;
    }

    public FoodItemDto addFoodItem(FoodItemDto foodItemToAdd) {
        FoodItem addedFoodItem = foodItemRepository
                .save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemToAdd));
        FoodItemDto addedFoodItemDto = FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(addedFoodItem);
        return addedFoodItemDto;
    }

    public FoodCatalogueDto getFoodCatalogueByRestaurantId(Integer restaurantId) {
        List<FoodItemDto> foodItemDtos = fetchFoodItemsByRestaurantId(restaurantId);
        RestaurantDto restaurantDto = fetchRestaurantDetails(restaurantId);
        FoodCatalogueDto foodCatalogueDto = new FoodCatalogueDto(foodItemDtos, restaurantDto);
        return foodCatalogueDto;
    }

    private List<FoodItemDto> fetchFoodItemsByRestaurantId(Integer restaurantId) {
        List<FoodItem> foodItems = foodItemRepository.findByRestaurantId(restaurantId);
        List<FoodItemDto> foodItemDtos = foodItems.stream()
                .map(foodItem -> FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem))
                .collect(Collectors.toList());
        return foodItemDtos;
    }

    private RestaurantDto fetchRestaurantDetails(Integer restaurantId) {
        RestaurantDto restaurantDetails = restTemplate
                .getForObject("http://RESTAURANT-LISTING/restaurants/{id}", RestaurantDto.class, restaurantId);
        return restaurantDetails;
    }
}
