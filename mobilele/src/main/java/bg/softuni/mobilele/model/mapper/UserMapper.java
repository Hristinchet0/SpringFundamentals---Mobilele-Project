package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.DTO.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDto userRegisterDto);
}
