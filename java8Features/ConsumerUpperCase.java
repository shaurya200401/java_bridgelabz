package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Program to demonstrate the usage of the Consumer interface
 * to print each element of a list of strings in uppercase.
 */
public class ConsumerUpperCase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "dave");

        // Defining a Consumer using lambda
        // Consumer<T> takes an input of type T and returns no result (void)
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        System.out.println("Printing names in uppercase: ");

        // The forEach method of Iterable takes a Consumer as an argument
        // It applies the consumer logic to every element in the list
        names.forEach(printUpperCase);
    }
}
