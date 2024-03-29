import exceptions.InvalidUsernameException;
import exceptions.IncorrectPasswordException;
import exceptions.FailedAttemptExceededException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String validUsername = "admin";
        String validPassword = "password";
        int numberOfAttempts = 0;
        boolean isLoggedIn = false;

        do {
            try {
                String formUsername = scanString("Enter username: ");

                if (!formUsername.equals(validUsername)) {
                    throw new InvalidUsernameException("Username is invalid. Please try again!");
                }

                String formPassword = scanString("Enter Password: ");

                if (!formPassword.equals(validPassword)) {
                    numberOfAttempts += 1;
                    throw new IncorrectPasswordException("Incorrect Password!");
                }

                isLoggedIn = true;
            } catch (InvalidUsernameException | IncorrectPasswordException e) {
                System.out.println(e.getMessage());
            }

            try {
                if (numberOfAttempts >= 3) {
                    throw new FailedAttemptExceededException("Multiple attempts failed!, try again later!");
                }
            } catch (FailedAttemptExceededException e) {
                System.out.print("\n" + e.getMessage());
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