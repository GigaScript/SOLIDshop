package interfaces;

import entity.User;
import repositorys.PrivilegesRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByPrivilege(final PrivilegesRepository privileges);

    Optional<User> findByEmail(String email);

    Optional<User> findByNickName(String nickName);

    List<User> findAllUsers();

    User addUser(User userToSave);
}
