package core.basesyntax;

import core.basesyntax.exception.PasswordValidationException;

public class UserService {
    public void registerUser(User user) {
        PasswordValidator passwordValidator = new PasswordValidator();
        try {
            passwordValidator.validate(user.getPassword(), user.getRepeatPassword());
        } catch (PasswordValidationException e) {
            System.out.println("Your passwords are incorrect. Try again.");
        } finally {
            if (user.getPassword().length() >= 10 && user.getRepeatPassword().length() >= 10
                    && user.getPassword().equals(user.getRepeatPassword())) {
                saveUser(user);
            }
        }

    }

    public void saveUser(User user) {
        System.out.println("User " + user.toString() + " was saved to database!!!");
    }
}
