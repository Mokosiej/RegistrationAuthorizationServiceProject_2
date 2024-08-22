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

    public void toRegister() {
        System.out.print("Введите имя пользователя:");
        String username = scanner.nextLine();

        System.out.print("Введите пароль:");
        String password = scanner.nextLine();

        if (userService.usernameAndPaswordCheck(username, password)) {
            System.out.println("Регистрация прошла успешно!");
        } else {
            System.out.println("Регистрация не удалась: возможно, имя пользователя уже существует или пароль ненадежен.");
        }
    }
}
