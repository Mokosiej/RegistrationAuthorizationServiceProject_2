package service;

public class CryptographerImpl implements Cryptographer {
    @Override
    public String encrypt(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            sb.append((char)(ch + 3));
        }
        return sb.toString();
    }


    @Override
    public String decrypt(String password) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                sb.append((char)(ch - 3));
            }
            return sb.toString();
        }


    @Override
    public boolean checkPassword(String password) {
        return false;
    }
}
