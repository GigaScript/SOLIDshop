package repositorys;

import entity.User;
import interfaces.UserRepository;

import java.util.*;

public class UserRepositoryInMemory implements UserRepository {
    private final Map<String, User> userRepository = new HashMap<>();

    @Override
    public Optional<User> findByPrivilege(final PrivilegesRepository privileges) {
        return userRepository.values().stream()
                .filter(user -> user.getPrivileges().equals(privileges))
                .findAny();
    }

    @Override
    public Optional<User> findByEmail(final String email) {
        return userRepository.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public Optional<User> findByNickName(String nickName) {
        return userRepository.values().stream()
                .filter(user -> user.getNickName().equals(nickName))
                .findAny();
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(userRepository.values());
    }

    @Override
    public User addUser(User user) {
        userRepository.put(user.getEmail(), user);
        return user;
    }
}
