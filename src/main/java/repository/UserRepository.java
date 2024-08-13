package repository;

import entity.User;

public interface UserRepository {
    void save(User user);
    boolean userNameOccupied(String username);
    User findUser(String userName);

}
