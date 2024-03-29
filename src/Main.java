import exceptions.InvalidUsernameException;
import exceptions.InvalidPasswordException;
import exceptions.FailedAttemptExceededException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String adminUsername = "admin";
        String adminPassword = "1234";
        int numberOfAttempts = 0;
        boolean isLoggedIn = false;

        do {
            try {
                String formUsername = scanString("Enter username: ");

                if (!formUsername.equals(adminUsername)) {
                    numberOfAttempts += 1;
                    throw new InvalidUsernameException("Username is not correct!");
                }

                String formPassword = scanString("Enter Password: ");

                if (!formPassword.equals(adminPassword)) {
                    numberOfAttempts += 1;
                    throw new InvalidPasswordException("Incorrect Password!");
                }

                isLoggedIn = true;
            } catch (InvalidUsernameException | InvalidPasswordException e) {
                System.out.println(e.getMessage());
            }

            try {
                if (numberOfAttempts >= 3) {
                    throw new FailedAttemptExceededException("Multiple attempts failed!, try again later!");
                }
            } catch (FailedAttemptExceededException e) {
                System.out.print(e.getMessage());
                System.exit(0);
            } finally {
                System.out.print("\n");
            }

        } while (!isLoggedIn);

        System.out.println("Success!");
    }

    private static String scanString(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }
}