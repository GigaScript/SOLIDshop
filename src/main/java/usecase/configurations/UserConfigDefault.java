package usecase.configurations;

import interfaces.PasswordEncoder;
import interfaces.UserConfig;
import interfaces.UserRepository;
import usecase.user.UserCreate;
import usecase.user.UserFind;
import usecase.user.UserLogin;

public class UserConfigDefault implements UserConfig {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserConfigDefault(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserCreate createUser() {
        return new UserCreate(userRepository, passwordEncoder);
    }

    @Override
    public UserFind findUser() {
        return new UserFind(userRepository);
    }

    @Override
    public UserLogin loginUser() {
        return new UserLogin(userRepository, passwordEncoder);
    }
}
