package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 8: Testing File Handling Methods
 * This class handles writing to and reading from a file.
 * JUnit tests verify IO operations and exception handling.
 */
class FileProcessor {
    // Writes content to a file
    public void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    // Reads content from a file
    public String readFromFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new IOException("File not found: " + filename);
        }
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}

public class FileProcessorTest {
    private final String TEST_FILENAME = "testfile.txt";

    @AfterEach
    public void cleanup() {
        File file = new File(TEST_FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }

    // Verify content is written and read correctly
    @Test
    public void testWriteAndRead() throws IOException {
        FileProcessor processor = new FileProcessor();
        String content = "Hello JUnit";

        processor.writeToFile(TEST_FILENAME, content);

        File file = new File(TEST_FILENAME);
        assertTrue(file.exists(), "File should exist after writing");

        String readContent = processor.readFromFile(TEST_FILENAME);
        assertEquals(content, readContent, "Read content should match written content");
    }

    // Verify IOException when file does not exist
    @Test
    public void testReadNonExistentFile() {
        FileProcessor processor = new FileProcessor();
        assertThrows(IOException.class, () -> {
            processor.readFromFile("non_existent_file.txt");
        }, "Should throw IOException if file does not exist");
    }
}
