package abhik26.food_delivery.user_info.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import abhik26.food_delivery.user_info.dto.UserDto;
import abhik26.food_delivery.user_info.entity.User;
import abhik26.food_delivery.user_info.mapper.UserMapper;
import abhik26.food_delivery.user_info.repo.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto addUser(UserDto userToAdd) {
        User addedUser = userRepository.save(UserMapper.INSTANCE.mapUserDtoToUser(userToAdd));
        UserDto addedUserDto = UserMapper.INSTANCE.mapUserToUserDto(addedUser);
        return addedUserDto;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserMapper.INSTANCE.mapUserToUserDto(user)).collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        UserDto userDtoById = null;
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userDtoById = UserMapper.INSTANCE.mapUserToUserDto(userOptional.get());
        }

        return userDtoById;
    }
}
