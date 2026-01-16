package Extras;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static int generateNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    public static int getUserGuess(Scanner sc) {
        System.out.print("Enter your guess (1-100): ");
        return sc.nextInt();
    }

    public static String checkGuess(int guess, int target) {
        if (guess > target) {
            return "Too high!";
        } else if (guess < target) {
            return "Too low!";
        } else {
            return "Correct!";
        }
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        int target = generateNumber();
        int attempts = 0;
        String result = "";

        System.out.println("Thinking of a number between 1 and 100...");

        while (!result.equals("Correct!")) {
            int guess = getUserGuess(sc);
            attempts++;
            result = checkGuess(guess, target);
            System.out.println(result);
        }

        System.out.println("You guessed the number in " + attempts + " attempts.");
        sc.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
