package java8Features;

import java.util.function.BiFunction;

/*
 * Program to demonstrate the BiFunction interface.
 * Takes two strings as input and concatenates them with a space in between.
 */
public class BiFunctionConcatenate {
    public static void main(String[] args) {
        // BiFunction<Input1, Input2, Output>
        // Here, it takes two Strings and returns a combined String
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;

        String str1 = "Hello";
        String str2 = "World";

        // Calling apply() on the BiFunction instance
        String result = concatenate.apply(str1, str2);

        System.out.println("Concatenated string: " + result);
    }
}
