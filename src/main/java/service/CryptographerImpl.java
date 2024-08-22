package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptographerImpl implements Cryptographer {
    public String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //для создания хэша пароля с алгоритмом SHA-256 (стандартный криптографический хэш-функция.)
            byte[] bytes = md.digest(password.getBytes());//преобразует строку пароля в байты и затем хэширует их.
            StringBuilder sb = new StringBuilder();//Байты преобразуются в строку шестнадцатеричных символов
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));//делает хэш читаемым как строку.
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean check(String password, String hashedPassword) {
        return hash(password).equals(hashedPassword);
    }
}
