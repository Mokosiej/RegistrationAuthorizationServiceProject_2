package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    public Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {

    }

    @Override
    public boolean userNameOccupied(String username) {
        return false;
    }

    @Override
    public User findUser(String userName) {
        return null;
    }
}
