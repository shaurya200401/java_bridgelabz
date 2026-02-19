package annotationsReflections.reflection;

import java.lang.reflect.Constructor;

/*
 * PROBLEM: Dynamically Create Objects
 * Problem Statement:
 * Write a program to create an instance of a Student class dynamically using Reflection 
 * without using the new keyword.
 * Concepts Tested:
 *  Class.getConstructor()
 *  Constructor.newInstance()
 */
class Student {
    private String name;

    public Student() {
        this.name = "Unknown";
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Student.class;

            // 1. Using Default Constructor
            System.out.println("Creating object using default constructor...");
            Constructor<?> defaultConstructor = clazz.getConstructor();
            Student s1 = (Student) defaultConstructor.newInstance();
            s1.display();

            // 2. Using Parameterized Constructor
            System.out.println("Creating object using parameterized constructor...");
            Constructor<?> paramConstructor = clazz.getConstructor(String.class);
            Student s2 = (Student) paramConstructor.newInstance("John Doe");
            s2.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
