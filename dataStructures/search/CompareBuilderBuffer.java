package dataStructures.search;

/**
 * Class to compare the performance of StringBuffer and StringBuilder for string
 * concatenation.
 */
public class CompareBuilderBuffer {

    public static void main(String[] args) {
        int iterations = 1000000; // 1 million strings
        String text = "hello";

        // Compare StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        System.out.println(
                "StringBuffer time for " + iterations + " concatenations: " + (durationBuffer / 1000000) + " ms");

        // Compare StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        System.out.println(
                "StringBuilder time for " + iterations + " concatenations: " + (durationBuilder / 1000000) + " ms");
    }
}
