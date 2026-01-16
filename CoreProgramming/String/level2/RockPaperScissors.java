package String.level2;

import java.util.Scanner;

// Rock-Paper-Scissors Game Program
public class RockPaperScissors {

    // Gets random computer choice
    public static String getComputerChoice() {
        int rand = (int) (Math.random() * 3);
        if (rand == 0)
            return "Rock";
        if (rand == 1)
            return "Paper";
        return "Scissors";
    }

    // Determines the winner
    public static String checkWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer))
            return "Draw";

        user = user.toLowerCase();
        computer = computer.toLowerCase();

        if (user.equals("rock")) {
            return computer.equals("scissors") ? "User" : "Computer";
        } else if (user.equals("paper")) {
            return computer.equals("rock") ? "User" : "Computer";
        } else if (user.equals("scissors")) {
            return computer.equals("paper") ? "User" : "Computer";
        }
        return "Invalid Input";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of games to play: ");
        int n = scanner.nextInt();

        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        String[][] gameHistory = new String[n][3];

        for (int i = 0; i < n; i++) {
            System.out.println("\nGame " + (i + 1));
            System.out.println("Enter choice (Rock, Paper, Scissors): ");
            String userChoice = scanner.next();
            String computerChoice = getComputerChoice();

            String winner = checkWinner(userChoice, computerChoice);

            gameHistory[i][0] = userChoice;
            gameHistory[i][1] = computerChoice;
            gameHistory[i][2] = winner;

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                computerWins++;
            else
                draws++;

            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Winner: " + winner);
        }

        double userWinPct = (n > 0) ? ((double) userWins / n) * 100 : 0;
        double computerWinPct = (n > 0) ? ((double) computerWins / n) * 100 : 0;

        System.out.println("\n--- Game Stats ---");
        System.out.printf("%-10s %-15s %-15s%n", "Game", "User", "Computer");
        System.out.println("----------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-15s %-15s Winner: %s%n", (i + 1), gameHistory[i][0], gameHistory[i][1],
                    gameHistory[i][2]);
        }

        System.out.println("----------------------------------------");
        System.out.printf("User Wins: %d (%.2f%%)%n", userWins, userWinPct);
        System.out.printf("Computer Wins: %d (%.2f%%)%n", computerWins, computerWinPct);

        scanner.close();
    }
}

