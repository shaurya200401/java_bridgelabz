package annotationsReflections.reflection;

import java.lang.reflect.*;
import java.util.Scanner;

/*
 * PROBLEM: Get Class Information
 * Problem Statement:
 * Write a program to accept a class name as input and display its methods, fields, and constructors using Reflection.
 * Concepts Tested:
 *  Class.forName()
 *  getMethods()
 *  getFields()
 *  getConstructors()
 */
public class ClassInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            System.out.println("\nClass Name: " + clazz.getName());

            // Display Fields
            System.out.println("\n--- Fields ---");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " "
                        + field.getName());
            }

            // Display Constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display Methods
            System.out.println("\n--- Methods ---");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName()
                        + " " + method.getName());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
        scanner.close();
    }
}
