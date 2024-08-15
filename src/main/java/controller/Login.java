package controller;

import service.UserService;

import java.util.Scanner;

public class Login {
    private final UserService userService;
    private final Scanner scanner;

    public Login(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.login(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed: Invalid username or password.");
        }
    }
}
