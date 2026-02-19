package annotationsReflections.reflection;

import java.lang.reflect.Field;

/*
 * PROBLEM: Access Private Field
 * Problem Statement:
 * Create a class Person with a private field age. Use Reflection to modify and retrieve its value.
 * Concepts Tested:
 *  getDeclaredField()
 *  setAccessible(true)
 *  Field.get()
 *  Field.set()
 */
class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            System.out.println("Original Age: " + person.getAge());

            // Get Class object
            Class<?> clazz = person.getClass();

            // Access private field 'age'
            Field ageField = clazz.getDeclaredField("age");

            // Make private field accessible
            ageField.setAccessible(true);

            // Modify value
            System.out.println("Modifying age to 30...");
            ageField.set(person, 30);

            // Retrieve value using reflection
            int newAge = (int) ageField.get(person);
            System.out.println("Updated Age (via Reflection): " + newAge);
            System.out.println("Updated Age (via Getter): " + person.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
