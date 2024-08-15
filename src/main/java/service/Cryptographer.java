package service;

public interface Cryptographer {
    String hash(String password);
    boolean check(String password, String hashedPassword);
}
