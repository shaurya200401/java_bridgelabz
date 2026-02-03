package exceptions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Program 13: Throw and Throws
 * 
 * Problem Statement:
 * 1. registerUser(String username) throws UserAlreadyExistsException.
 * 2. checkUserExistence(String username) throws UserNotFoundException.
 * 3. Main handles these exceptions.
 */

// Custom Exception for Existing User
class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

// Custom Exception for User Not Found
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {
    // Simulated database of users
    private Set<String> registeredUsers = new HashSet<>();

    public UserService() {
        // Pre-populate some users
        registeredUsers.add("alice");
        registeredUsers.add("bob");
    }

    // Method to register a user
    public void registerUser(String username) throws UserAlreadyExistsException {
        if (registeredUsers.contains(username.toLowerCase())) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists in the system.");
        }
        registeredUsers.add(username.toLowerCase());
        System.out.println("User '" + username + "' registered successfully.");
    }

    // Method to check if user exists
    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!registeredUsers.contains(username.toLowerCase())) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists.");
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        Scanner scanner = new Scanner(System.in);

        try {
            // Test 1: Try to check non-existent user
            System.out.print("Check user (e.g. charlie): ");
            String checkName = scanner.next();
            try {
                service.checkUserExistence(checkName);
            } catch (UserNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Test 2: Try to register existing user
            System.out.print("Register user (e.g. alice): ");
            String regName = scanner.next();
            try {
                service.registerUser(regName);
            } catch (UserAlreadyExistsException e) {
                System.out.println("Registration Failed: " + e.getMessage());
            }

            // Test 3: Successful registration
            System.out.print("Register new user (e.g. dave): ");
            String newName = scanner.next();
            try {
                service.registerUser(newName);
            } catch (UserAlreadyExistsException e) {
                System.out.println("Registration Failed: " + e.getMessage());
            }

        } finally {
            scanner.close();
        }
    }
}
