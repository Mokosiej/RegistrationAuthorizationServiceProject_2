package entity;

public class User {
    private final String username;
    private final String password;
    private int failedLoginAttempts;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.failedLoginAttempts = 0;
    }

    public int getFailedLoginAttempts() {

        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {

        this.failedLoginAttempts = failedLoginAttempts;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }

    public void resetLoginAttempts() {
        this.failedLoginAttempts = 0;
    }
}
