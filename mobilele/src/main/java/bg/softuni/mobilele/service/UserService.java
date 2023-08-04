package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.DTO.UserLoginDto;
import bg.softuni.mobilele.model.DTO.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private CurrentUser currentUser;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> userByEmail = userRepository.findByEmail(userLoginDto.getEmail());

        if (userByEmail.isEmpty()) {
            LOGGER.info("User with name [{}] not found", userLoginDto.getEmail());
            return false;
        }

        String rawPassword = userLoginDto.getPassword();
        String encodedPassword = userByEmail.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
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

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto) {
        UserEntity newUser = new UserEntity();

        newUser.setActive(true);
        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setFirstName(userRegisterDto.getFirstName());
        newUser.setLastName(userRegisterDto.getLastName());
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));


        userRepository.save(newUser);

        login(newUser);

    }
}
