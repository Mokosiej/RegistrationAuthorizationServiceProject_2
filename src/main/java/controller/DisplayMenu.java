package controller;

import com.sun.tools.javac.Main;
import repository.UserRepository;

import repository.UserRepositoryImpl;
import service.Cryptographer;
import service.CryptographerImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class DisplayMenu {
    private final UserRepository userRepository;
    private final Cryptographer cryptographer;
    private final UserService userService;
    private final Scanner scanner;
    private final Login login;
    private final SignIn signIn;


    public DisplayMenu() {
        this.userRepository = new UserRepositoryImpl();
        this.cryptographer = new CryptographerImpl();
        this.userService = new UserServiceImpl(userRepository, cryptographer);
        this.scanner = new Scanner(System.in);
        this.login = new Login(userService, scanner);
        this.signIn = new SignIn(userService, scanner);
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