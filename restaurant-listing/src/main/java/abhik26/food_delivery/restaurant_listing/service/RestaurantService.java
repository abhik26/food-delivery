package abhik26.food_delivery.restaurant_listing.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import abhik26.food_delivery.restaurant_listing.dto.RestaurantDTO;
import abhik26.food_delivery.restaurant_listing.entity.Restaurant;
import abhik26.food_delivery.restaurant_listing.mapper.RestaurantMapper;
import abhik26.food_delivery.restaurant_listing.repo.RestaurantRepository;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        List<RestaurantDTO> restaurantDTOs = restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
                .collect(Collectors.toList());

        return restaurantDTOs;
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantToAdd) {
        Restaurant savedRestaurant = restaurantRepository
                .save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantToAdd));
        RestaurantDTO restaurantDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
        return restaurantDTO;
    }

    public RestaurantDTO getRestaurantById(Integer id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        RestaurantDTO restaurantDTO = null;

        if (restaurantOptional.isPresent()) {
            restaurantDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantOptional.get());
        }

        return restaurantDTO;
    }
}
