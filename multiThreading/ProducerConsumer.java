package multiThreading;

/*
 * ProducerConsumer.java
 *
 * Functionality:
 * This program implements the classic Producer-Consumer problem. It uses a 
 * shared queue to facilitate communication between a producer thread (which 
 * generates task integers) and a consumer thread (which processes them). 
 * Synchronization is handled via wait() and notifyAll() to prevent race conditions.
 *
 * Challenges Faced:
 * - Managing the shared resource safely to prevent unexpected exceptions.
 * - Ensuring threads properly wait and notify each other to prevent deadlocks.
 * - Terminating the threads smoothly after fulfilling the specific target quota.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) {
        // Shared queue to act as the communication channel
        Queue<Integer> sharedQueue = new LinkedList<>();
        // Maximum capacity of the shared resource queue
        int maxCapacity = 5;
        // Total tasks to generate and consume
        int totalTasks = 15;

        // Create the producer object and pass dependencies
        Producer producerObj = new Producer(sharedQueue, maxCapacity, totalTasks);
        // Create the consumer object and pass dependencies
        Consumer consumerObj = new Consumer(sharedQueue, totalTasks);

        // Create the producer thread bound to the runnable
        Thread producer = new Thread(producerObj);
        // Create the consumer thread bound to the runnable
        Thread consumer = new Thread(consumerObj);

        // Start producer thread execution
        producer.start();
        // Start consumer thread execution
        consumer.start();

        // Try wait blocks for synchronizing the main thread
        try {
            // Wait for producer to finish execution
            producer.join();
            // Wait for consumer to finish execution
            consumer.join();
        } catch (InterruptedException e) {
            // Handle interrupt during terminal wait
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        // Final completion message printed to console
        System.out.println("Producer and Consumer have finished their execution.");
    }
}

/*
 * Producer class
 * Responsibilities: Generates integer tasks and stores them into the shared
 * queue continuously.
 */
class Producer implements Runnable {
    // Shared queue reference for tasks
    private final Queue<Integer> sharedQueue;
    // Maximum queue capacity limit
    private final int maxCapacity;
    // Total number of tasks to produce
    private final int totalTasks;

    // Parameterized constructor to initialize the required references
    public Producer(Queue<Integer> sharedQueue, int maxCapacity, int totalTasks) {
        // Assign shared queue parameter
        this.sharedQueue = sharedQueue;
        // Assign max capacity parameter
        this.maxCapacity = maxCapacity;
        // Assign total tasks parameter
        this.totalTasks = totalTasks;
    }

    @Override
    public void run() {
        // Loop continuously to produce new tasks
        for (int i = 1; i <= totalTasks; i++) {
            // Synchronize execution on the shared queue object
            synchronized (sharedQueue) {
                // Loop to make thread wait while queue remains full
                while (sharedQueue.size() == maxCapacity) {
                    // Try wait block logic
                    try {
                        // Wait for consumer to process tasks first
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        // Handle unexpected thread interruption error
                        System.out.println("Producer interrupted.");
                    }
                }

                // Add the new task directly to the queue
                sharedQueue.add(i);
                // Print task production message
                System.out.println("Produced task: " + i);
                // Wake up the consumer thread safely
                sharedQueue.notifyAll();
            }

            // Try thread sleep logic
            try {
                // Sleep momentarily to simulate production effort
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle sleep execution interruption
                System.out.println("Producer sleep interrupted.");
            }
        }
    }
}

/*
 * Consumer class
 * Responsibilities: Retrieves integer tasks from the shared queue and processes
 * them gradually.
 */
class Consumer implements Runnable {
    // Shared queue reference for tasks
    private final Queue<Integer> sharedQueue;
    // Total number of tasks to consume overall
    private final int totalTasks;

    // Parameterized constructor to initialize the required references
    public Consumer(Queue<Integer> sharedQueue, int totalTasks) {
        // Assign shared queue parameter
        this.sharedQueue = sharedQueue;
        // Assign total tasks parameter
        this.totalTasks = totalTasks;
    }

    @Override
    public void run() {
        // Define tracking variable for consumed task quantities
        int consumedCount = 0;

        // Loop iteration until all tasks are consumed
        while (consumedCount < totalTasks) {
            // Synchronize execution on the shared queue object
            synchronized (sharedQueue) {
                // Loop to make thread wait while queue remains empty
                while (sharedQueue.isEmpty()) {
                    // Try wait block logic
                    try {
                        // Wait for producer to generate new tasks
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        // Handle unexpected thread interruption error
                        System.out.println("Consumer interrupted.");
                    }
                }

                // Retrieve and process task by removing from queue
                int task = sharedQueue.poll();
                // Increment total consumed elements counter
                consumedCount++;
                // Print explicit message indicating task consumption
                System.out.println("Consumed task: " + task);
                // Wake up the producer thread safely
                sharedQueue.notifyAll();
            }

            // Try thread sleep logic
            try {
                // Sleep momentarily to simulate consumption delays
                Thread.sleep(150);
            } catch (InterruptedException e) {
                // Handle sleep execution interruption
                System.out.println("Consumer sleep interrupted.");
            }
        }
    }
}
