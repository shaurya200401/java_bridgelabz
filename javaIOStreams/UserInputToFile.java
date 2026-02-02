package javaIOStreams;

/*
 * Program 3: Read User Input from Console
 * Reads user's name, age, and favorite programming language.
 * Saves the input data into a text file using BufferedReader and FileWriter.
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {

    public static void main(String[] args) {
        // BufferedReader to read from console (System.in)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileWriter writer = new FileWriter("user_details.txt")) {

            // Reading user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Formatting the output
            String output = "User Details:\n" +
                    "Name: " + name + "\n" +
                    "Age: " + age + "\n" +
                    "Favorite Language: " + language + "\n";

            // Writing to file
            writer.write(output);

            System.out.println("Data saved successfully to 'user_details.txt'.");

        } catch (IOException e) {
            // Handling IO exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
