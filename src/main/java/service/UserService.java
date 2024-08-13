package service;

public interface UserService {
    void register(String username, String password);
    boolean isAuthorised(String username, String password);
}
