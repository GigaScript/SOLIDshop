package usecase.user;

import entity.User;
import interfaces.UserRepository;
import repositorys.PrivilegesRepository;

import java.util.List;
import java.util.Optional;

public final class UserFind {
    private final UserRepository repository;

    public UserFind(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findByPrivilege(PrivilegesRepository privileges) {
        return repository.findByPrivilege(privileges);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<User> findByNickName(final String nickName) {
        return repository.findByNickName(nickName);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

}
