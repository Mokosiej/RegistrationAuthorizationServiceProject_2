package controller;

import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.Cryptographer;
import service.CryptographerImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class DisplayMenu {
    UserRepository userRepository = new UserRepositoryImpl();
    Cryptographer cryptographer = new CryptographerImpl();
    UserService userService = new UserServiceImpl(userRepository, cryptographer);

    Scanner scanner = new Scanner(System.in);
    Login login = new Login(userService, scanner);
    SignIn signIn = new SignIn(userService, scanner);

    public DisplayMenu() {

    }

    public void startProgram() {
    int choice = -1;

        while (true) {
            displayMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Wrong input, pls use only number");
                scanner.nextLine();
                continue;
            }


            switch (choice) {
                case 1 -> signIn.toRegister();
                case 2 -> login.login();
                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again");
            }

        }
    }

    private static void displayMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Pls choose an option (number only)");
    }


}