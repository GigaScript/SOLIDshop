package excption;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String userEmail) {
        super("Пользователь не создан. Пользователь с email: " + userEmail + " уже существует");
    }
}
