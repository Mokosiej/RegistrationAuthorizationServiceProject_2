package service;

public interface UserService {

    boolean usernameAndPaswordCheck(String username, String password);

    boolean login(String username, String password);
}
