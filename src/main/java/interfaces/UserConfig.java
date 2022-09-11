package interfaces;

import usecase.user.UserCreate;
import usecase.user.UserFind;
import usecase.user.UserLogin;

public interface UserConfig {
    UserCreate createUser();

    UserFind findUser();

    UserLogin loginUser();
}
