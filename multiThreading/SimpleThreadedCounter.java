package multiThreading;

/*
 * SimpleThreadedCounter.java
 *
 * Functionality:
 * This program demonstrates a simple threaded counter where multiple threads
 * count up to a user-specified limit. The threads run concurrently and use
 * a shared monitor lock to coordinate their turns. Each thread is responsible
 * for a portion of the range based on modular arithmetic (turn-based counting).
 *
 * Challenges Faced:
 * - Coordinating threads to maintain strict sequential output ordering.
 * - Avoiding deadlocks at the end of execution by utilizing proper notifyAll() signals.
 * - Processing user inputs safely with try-catch blocks and validations.
 */
import java.util.Scanner;

public class SimpleThreadedCounter {
    // Shared counter variable
    private static int currentCount = 1;

    public static void main(String[] args) {
        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // Prompt user for the limit
        System.out.print("Enter the counting limit: ");
        // Initialize limit variable
        int limit = 0;

        // Basic error handling for user input
        try {
            // Read next integer from user
            limit = scanner.nextInt();
        } catch (Exception e) {
            // Handle invalid input exception
            System.out.println("Invalid input. Please enter a valid integer.");
            // Exit program on failure
            return;
        } finally {
            // Close scanner to prevent memory leaks
            scanner.close();
        }

        // Validate if limit count is positive
        if (limit <= 0) {
            // Output validation error message
            System.out.println("Limit must be greater than 0.");
            // Exit program on failure
            return;
        }

        // Shared lock object for thread synchronization
        Object lock = new Object();
        // Constant representing number of threads to use
        int numThreads = 3;

        // Final copy of limit for use in lambda expression safely
        final int finalLimit = limit;

        // Loop to create and start threads
        for (int i = 0; i < numThreads; i++) {
            // Thread ID for identifying whose turn it is
            int threadId = i;

            // Create a new thread using lambda expression
            Thread t = new Thread(() -> {
                // Loop indefinitely until the counting limit is reached
                while (true) {
                    // Synchronize on the shared lock
                    synchronized (lock) {
                        // Check if overall count exceeds the limit
                        if (currentCount > finalLimit) {
                            // Wake up other waiting threads so they can exit gracefully
                            lock.notifyAll();
                            // Break the thread's infinite loop
                            break;
                        }

                        // Check if it's the current thread's turn
                        if ((currentCount - 1) % numThreads == threadId) {
                            // Print the concurrent count and thread information
                            System.out.println("Thread " + (threadId + 1) + " counts: " + currentCount);
                            // Increment the shared global counter
                            currentCount++;
                            // Notify all other waiting threads to check their turns
                            lock.notifyAll();
                        } else {
                            // Try block for thread waiting
                            try {
                                // Wait for our scheduled turn
                                lock.wait();
                            } catch (InterruptedException e) {
                                // Handle thread interruption error
                                System.out.println("Thread interrupted: " + e.getMessage());
                            }
                        }
                    }
                }
            });

            // Start the constructed thread
            t.start();
        }
    }
}
