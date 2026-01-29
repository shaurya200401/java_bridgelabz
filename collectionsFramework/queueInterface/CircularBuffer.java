package collectionsFramework.queueInterface;

import java.util.Arrays;

/**
 * This class implements a Circular Buffer (Ring Buffer) using an array.
 * It has a fixed size. When full, adding a new element overwrites the oldest
 * one.
 */
public class CircularBuffer {

    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    /**
     * Adds an element to the buffer.
     * Overwrites the oldest element if the buffer is full.
     * 
     * @param input The element to add
     */
    public void add(int input) {
        // If full, advance head to "forget" the oldest element
        if (size == capacity) {
            head = (head + 1) % capacity;
            size--; // Temporarily decrease size as we are about to overwrite/add
        }

        buffer[tail] = input;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int current = head;
        for (int i = 0; i < size; i++) {
            sb.append(buffer[current]);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = (current + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        System.out.println("Adding 1, 2, 3");
        cb.add(1);
        cb.add(2);
        cb.add(3);
        System.out.println("Buffer: " + cb);

        System.out.println("Adding 4 (Should overwrite 1)");
        cb.add(4);
        System.out.println("Buffer: " + cb);

        System.out.println("Adding 5 (Should overwrite 2)");
        cb.add(5);
        System.out.println("Buffer: " + cb);
    }
}
