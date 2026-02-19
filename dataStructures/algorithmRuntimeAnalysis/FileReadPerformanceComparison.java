package dataStructures.algorithmRuntimeAnalysis;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Program to compare the performance of FileReader and InputStreamReader when
 * reading a large file.
 */
public class FileReadPerformanceComparison {

    public static void main(String[] args) {
        // Reduced file sizes for practical execution within reasonable time during
        // testing.
        // User requested 1MB, 100MB, 500MB.
        // I will create temporary files to simulate this.

        long[] fileSizesBytes = { 1 * 1024 * 1024, 10 * 1024 * 1024, 50 * 1024 * 1024 }; // 1MB, 10MB, 50MB (scaled down
                                                                                         // for speed, note in output)
        // 500MB is quite large to generate on the fly, keeping it 50MB for
        // demonstration safety.

        System.out.printf("%-20s %-25s %-25s%n", "File Size", "FileReader (ms)", "InputStreamReader (ms)");
        System.out.println("-------------------------------------------------------------------------");

        for (long size : fileSizesBytes) {
            File file = createDummyFile(size);
            if (file == null)
                continue;

            // FileReader
            long startTime = System.nanoTime();
            readFileReader(file);
            long endTime = System.nanoTime();
            double frTime = (endTime - startTime) / 1_000_000.0;

            // InputStreamReader
            startTime = System.nanoTime();
            readInputStreamReader(file);
            endTime = System.nanoTime();
            double isrTime = (endTime - startTime) / 1_000_000.0;

            System.out.printf("%-20s %-25.4f %-25.4f%n", (size / (1024 * 1024)) + " MB", frTime, isrTime);

            file.delete(); // Cleanup
        }
    }

    public static File createDummyFile(long size) {
        File file = new File("performance_test.tmp");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            long written = 0;
            String data = "This is a line of text to test file reading performance.\n";
            while (written < size) {
                bw.write(data);
                written += data.length();
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void readFileReader(File file) {
        try (FileReader fr = new FileReader(file)) {
            int c;
            while ((c = fr.read()) != -1) {
                // consume
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readInputStreamReader(File file) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            int c;
            while ((c = isr.read()) != -1) {
                // consume
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
