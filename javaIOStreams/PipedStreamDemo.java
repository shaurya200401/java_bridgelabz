package javaIOStreams;

/*
 * Program 8: Piped Streams - Inter-Thread Communication
 * Demonstrates communication between two threads using PipedInputStream and PipedOutputStream.
 * One thread writes data, and another reads it.
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

    public static void main(String[] args) {
        try {
            final PipedOutputStream pos = new PipedOutputStream();
            final PipedInputStream pis = new PipedInputStream(pos);

            // Thread for writing data
            Thread writerThread = new Thread(() -> {
                try {
                    String[] messages = { "Hello", "from", "Piped", "Stream", "World!" };
                    for (String msg : messages) {
                        pos.write(msg.getBytes());
                        // Add a space separator
                        pos.write(" ".getBytes());
                        Thread.sleep(500); // Simulate delay
                    }
                    pos.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // Thread for reading data
            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    System.out.println(); // New line after reading all
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("Starting piped stream communication...");
            writerThread.start();
            readerThread.start();

            // Wait for threads to finish
            writerThread.join();
            readerThread.join();
            System.out.println("Communication finished.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
