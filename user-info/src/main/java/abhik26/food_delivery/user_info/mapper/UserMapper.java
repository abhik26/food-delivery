package abhik26.food_delivery.user_info.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import abhik26.food_delivery.user_info.dto.UserDto;
import abhik26.food_delivery.user_info.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapUserToUserDto(User user);

    User mapUserDtoToUser(UserDto userDto);
}
