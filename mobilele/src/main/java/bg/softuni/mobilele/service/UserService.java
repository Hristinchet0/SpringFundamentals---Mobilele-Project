package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.DTO.UserLoginDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> userByEmail = userRepository.findByEmail(userLoginDto.getUsername());

        if(userByEmail.isEmpty()) {
            LOGGER.info("User with name [{}] not found", userLoginDto.getUsername());
            return false;
        }

        boolean success = userByEmail.get().getPassword().equals(userLoginDto.getPassword());

        if(success) {
            login(userByEmail.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    private void logout() {
        currentUser.clear();
    }
}
