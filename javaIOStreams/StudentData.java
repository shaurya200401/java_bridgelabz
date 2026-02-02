package javaIOStreams;

/*
 * Program 7: Data Streams - Store and Retrieve Primitive Data
 * Stores student details (roll number, name, GPA) in a binary file.
 * Retrieves and displays the data using DataInputStream and DataOutputStream.
 */

import java.io.*;

public class StudentData {

    public static void main(String[] args) {
        String filename = "students.dat";

        // Writing primitive data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            // Student 1
            dos.writeInt(101);
            dos.writeUTF("John Doe");
            dos.writeDouble(3.8);

            // Student 2
            dos.writeInt(102);
            dos.writeUTF("Jane Smith");
            dos.writeDouble(3.9);

            System.out.println("Student data written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

        // Reading primitive data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nReading Student Data:");

            // Loop until end of file (EOFException will be thrown)
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
