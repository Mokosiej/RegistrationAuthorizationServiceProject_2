import controller.Login;
import controller.SignIn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Pls choose: ");
            System.out.println("Sign in");
            System.out.println("Log in ");
            System.out.println("Exit");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "sign in" -> SignIn.signIn();
                case "log in" -> Login.logIn();
                case "exit" -> {break;}
                default -> System.out.println("something wrong, pls try again");
            }

            }
        }



}
