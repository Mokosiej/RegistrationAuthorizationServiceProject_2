package service;

public interface Cryptographer {
    public String encrypt(String password);
    public String decrypt(String password);

    public boolean checkPassword(String password);

}
