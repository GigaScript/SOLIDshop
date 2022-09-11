package usecase.user;

import entity.User;
import excption.UserAlreadyExistsException;
import interfaces.PasswordEncoder;
import interfaces.UserRepository;
import usecase.validators.UserValidator;

public class UserCreate {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserCreate(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Объект пользователя не найден");
        }
        User userToSave = User.builder()
                .setEmail(user.getEmail())
                .setPassword(passwordEncoder.encode(user.getEmail() + user.getPassword()))
                .setNickName(user.getNickName())
                .setPrivileges(user.getPrivileges())
                .build();
        return repository.addUser(userToSave);
    }
}
