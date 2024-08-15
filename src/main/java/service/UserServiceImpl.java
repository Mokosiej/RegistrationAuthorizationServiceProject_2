package service;

import entity.User;
import repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Cryptographer cryptographer;

    public UserServiceImpl(UserRepository userRepository, Cryptographer cryptographer) {
        this.userRepository = userRepository;
        this.cryptographer = cryptographer;
    }

    public boolean register(String username, String password) {
        if (username.length() < 3 || !isPasswordValid(password)) {
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

        return cryptographer.check(password, user.getPassword());
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*\\W.*");
    }
}

