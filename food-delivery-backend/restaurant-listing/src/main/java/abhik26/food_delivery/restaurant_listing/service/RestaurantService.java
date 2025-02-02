package abhik26.food_delivery.restaurant_listing.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import abhik26.food_delivery.restaurant_listing.dto.RestaurantDto;
import abhik26.food_delivery.restaurant_listing.entity.Restaurant;
import abhik26.food_delivery.restaurant_listing.mapper.RestaurantMapper;
import abhik26.food_delivery.restaurant_listing.repo.RestaurantRepository;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        List<RestaurantDto> restaurantDTOs = restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant))
                .collect(Collectors.toList());

        return restaurantDTOs;
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantToAdd) {
        Restaurant savedRestaurant = restaurantRepository
                .save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantToAdd));
        RestaurantDto restaurantDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
        return restaurantDTO;
    }

    public RestaurantDto getRestaurantById(Integer id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        RestaurantDto restaurantDTO = null;

        if (restaurantOptional.isPresent()) {
            restaurantDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantOptional.get());
        }

        return restaurantDTO;
    }
}
