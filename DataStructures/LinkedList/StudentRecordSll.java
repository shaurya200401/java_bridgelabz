package DataStructures.LinkedList;

import java.util.Scanner;

/**
 * Manages student records using a Singly Linked List.
 * Each node stores student details: Roll Number, Name, Age, and Grade.
 */
public class StudentRecordSll {

    // Node class representing a student
    static class Node {
        int rollNumber;
        String name;
        int age;
        char grade;
        Node next;

        public Node(int rollNumber, String name, int age, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Node head;

    // Add a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at the beginning.");
    }

    // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Student added at the end.");
    }

    // Add a new student record at a specific position (1-based index)
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Student added at position " + position + ".");
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Student added at position " + position + ".");
        }
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
        }
    }

    // Search for a student record by Roll Number
    public void searchByRollNumber(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: "
                        + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age
                    + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update a student's grade based on Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        StudentRecordSll list = new StudentRecordSll();
        // Add sample data
        list.addAtEnd(101, "Alice", 20, 'A');
        list.addAtEnd(102, "Bob", 21, 'B');
        list.addAtBeginning(100, "Charlie", 19, 'C');

        // Display
        list.displayAll();

        // Specific Position
        list.addAtPosition(2, 105, "David", 22, 'A');
        list.displayAll();

        // Search
        list.searchByRollNumber(102);

        // Update Grade
        list.updateGrade(102, 'A');
        list.searchByRollNumber(102);

        // Delete
        list.deleteByRollNumber(101);
        list.displayAll();
    }
}
