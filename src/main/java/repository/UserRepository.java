package repository;

import entity.User;

public interface UserRepository {
    boolean addUser(User user);
    User getUser(String username);
}
