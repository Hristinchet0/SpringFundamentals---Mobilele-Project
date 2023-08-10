package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.DTO.UserLoginDto;
import bg.softuni.mobilele.model.DTO.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private CurrentUser currentUser;

    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> userByEmail = userRepository.findByEmail(userLoginDto.getUsername());

        if (userByEmail.isEmpty()) {
            LOGGER.info("User with name [{}] not found", userLoginDto.getUsername());
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

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto) {

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDto);
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(newUser);
        login(newUser);

    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
        currentUser.setEmail(userEntity.getEmail());
    }
}
