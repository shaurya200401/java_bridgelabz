package String.level3;

import java.util.Scanner;

/*
 * Program: Deck of Cards Simulation
 * Purpose: Initailizes, shuffles, and distributes a deck of playing cards to players.
 */
public class DeckOfCards {

    // Method to initialize standard deck
    public static String[] initializeDeck() {
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        String[] deck = new String[suits.length * ranks.length];
        int k = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[k++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }

    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));

            // Swap to shuffle
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        String[][] hands = new String[players][cardsPerPlayer];
        int cardIdx = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                if (cardIdx < deck.length) {
                    hands[i][j] = deck[cardIdx++];
                }
            }
        }
        return hands;
    }

    public static void main(String[] args) {
        // Initialize
        String[] deck = initializeDeck();
        System.out.println("Deck initialized with " + deck.length + " cards.");

        // Shuffle
        deck = shuffleDeck(deck);
        System.out.println("Deck shuffled.");

        // Distribute to 4 players, 9 cards each
        int players = 4;
        int cardsPerPlayer = 9;
        String[][] playerHands = distributeCards(deck, players, cardsPerPlayer);

        // Print hands
        for (int i = 0; i < players; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < cardsPerPlayer; j++) {
                System.out.println(playerHands[i][j]);
            }
        }
    }
}
