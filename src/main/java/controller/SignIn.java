package controller;

import service.UserService;

import java.util.Scanner;

public class SignIn {
    private final UserService userService;
    private final Scanner scanner;

    public SignIn(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    public void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.register(username, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed: Username might already exist or password is weak.");
        }
    }
}
