package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public boolean addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
