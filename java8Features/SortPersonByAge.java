package java8Features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Program to create a list of Person objects and sort them by age
 * in ascending order using lambda expressions.
 */
public class SortPersonByAge {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        // Adding Person objects to the list
        people.add(new Person("Alice", 30, 50000));
        people.add(new Person("Bob", 25, 45000));
        people.add(new Person("Charlie", 35, 60000));
        people.add(new Person("David", 28, 55000));

        System.out.println("Original List:");
        people.forEach(System.out::println);

        // Sorting by age in ascending order using lambda expression
        // (p1, p2) -> Integer.compare(...) implements the Comparator interface
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("\nSorted List (by Age):");
        // Using forEach to print each person
        people.forEach(System.out::println);
    }
}
