package usecase.user;

import entity.User;
import excption.NotAllowedException;
import interfaces.PasswordEncoder;
import interfaces.UserRepository;

public class UserLogin {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserLogin(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(final String email, final String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Не верный логин или пароль"));
        String hashedPassword = passwordEncoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Не верный логин или пароль");
        return user;
    }
}
