package usecase.validators;

import entity.User;
import excption.UserValidationException;

public final class UserValidator {
    public static void validateCreateUser(final User user) {
        if (user == null) {
            throw new UserValidationException("Объект пользователя не найден");
        } else if (user.getPrivileges() == null) {
            throw new UserValidationException("Ошибка создания пользователя, не указана роль");
        } else if (validateUserEmail(user.getEmail())) {
            throw new UserValidationException("Ошибка создания пользователя, не корректный email: " + user.getEmail());
        } else if (user.getPassword().length() <= 3) {
            throw new UserValidationException("Ошибка создания пользователя, пароль должен быть более 3х символов");
        }
    }

    private UserValidator() {
    }

    public static boolean validateUserEmail(String email) {
        if (email.isEmpty() ||
                !email.contains("@") ||
                email.length() <= 4 ||
                email.chars().filter(ch -> ch == '.').count() > 1.0) {
            return true;
        } else {
            return false;
        }
    }

}
