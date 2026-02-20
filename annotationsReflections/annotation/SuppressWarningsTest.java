package annotationsReflections.annotation;

import java.util.ArrayList;

/*
 * Exercise 3: Suppress Unchecked Warnings
 * Problem Statement:
 * Create an ArrayList without generics and use @SuppressWarnings("unchecked") to hide compilation warnings.
 */
public class SuppressWarningsTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Creating a raw ArrayList (would normally cause a warning)
        ArrayList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add(100); // Mixed types allowed in raw list

        System.out.println("List contents: " + list);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
