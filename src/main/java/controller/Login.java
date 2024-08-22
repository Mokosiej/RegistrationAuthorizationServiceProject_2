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
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();

        System.out.print("Введите пароль:");
        String password = scanner.nextLine();

        if (userService.login(username, password)) {
            System.out.println("Вход выполнен успешно!");
        } else {
            System.out.println("Ошибка входа: Неверное имя пользователя или пароль.");
        }
    }
}
