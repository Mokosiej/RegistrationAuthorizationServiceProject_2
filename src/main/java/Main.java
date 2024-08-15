import controller.Login;
import controller.SignIn;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.Cryptographer;
import service.CryptographerImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        Cryptographer cryptographer = new CryptographerImpl();
        UserService userService = new UserServiceImpl(userRepository, cryptographer);

        Scanner scanner = new Scanner(System.in);
        Login login = new Login(userService, scanner);
        SignIn signIn = new SignIn(userService, scanner);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> signIn.register();
                case 2 -> login.login();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}




