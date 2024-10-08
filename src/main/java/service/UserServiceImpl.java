package service;

import entity.User;
import repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Cryptographer cryptographer;
    private static final int MAX_LOGIN_ATTEMPTS = 3; // Максимальное количество попыток

    public UserServiceImpl(UserRepository userRepository, Cryptographer cryptographer) {
        this.userRepository = userRepository;
        this.cryptographer = cryptographer;
    }

    public boolean usernameAndPaswordCheck(String username, String password) {
        if (username.length() < 3 || !isPasswordValid(password)) { //имя больше 3 символов
            return false;
        }

        String hashedPassword = cryptographer.hash(password);
        User user = new User(username, hashedPassword);
        return userRepository.addUser(user);
    }

    public boolean login(String username, String password) {
        User user = userRepository.getUser(username);
        if (user == null) {
            return false;
        }

        if (user.getFailedLoginAttempts() >= MAX_LOGIN_ATTEMPTS) {
            System.out.println("После многочисленных попыток функции входа в систему блокируются.");
            return false;
        }

        if (cryptographer.check(password, user.getPassword())) {
            user.resetLoginAttempts();
            return true;
        } else {
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            System.out.println("Неправильный пароль, попытки остаются" +
                    (MAX_LOGIN_ATTEMPTS - user.getFailedLoginAttempts()));
            return false;
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*\\W.*");
    } //ввод пароля 8 символов, наличие цифры .*\\d.* ,  .*\\W.* проверяет наличие хотя бы одного неалфавитного символа
}