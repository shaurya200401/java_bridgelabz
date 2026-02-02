package javaIOStreams;

/*
 * Program 5: ByteArray Stream - Convert Image to ByteArray
 * Converts an image file to a byte array and then writes it back to a new image file.
 * Uses ByteArrayInputStream and ByteArrayOutputStream.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageToByteArray {

    public static void main(String[] args) {
        String sourceImagePath = "input_image.jpg";
        String destImagePath = "output_image.jpg";

        // Create a dummy image file if it doesn't exist
        createDummyImage(sourceImagePath);

        try {
            // 1. Read image to byte array
            byte[] imageBytes = convertImageToByteArray(sourceImagePath);
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes.");

            // 2. Write byte array back to new image file
            convertByteArrayToImage(imageBytes, destImagePath);

            System.out.println("Byte array written back to " + destImagePath);

            // Verify if files are identical
            if (compareFiles(sourceImagePath, destImagePath)) {
                System.out.println("Success: The new file is identical to the original.");
            } else {
                System.out.println("Failure: The files are different.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Helper to create a dummy image (just random bytes)
    private static void createDummyImage(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                // Determine size
                byte[] dummyData = new byte[1024];
                for (int i = 0; i < dummyData.length; i++)
                    dummyData[i] = (byte) i;
                fos.write(dummyData);
                System.out.println("Created dummy image file: " + path);
            } catch (IOException e) {
                System.out.println("Failed to create dummy image: " + e.getMessage());
            }
        }
    }

    private static byte[] convertImageToByteArray(String path) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }
        }
        return baos.toByteArray();
    }

    private static void convertByteArrayToImage(byte[] data, String path) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
                FileOutputStream fos = new FileOutputStream(path)) {

            byte[] buffer = new byte[1024];
            int read;
            while ((read = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
        }
    }

    // Simple file comparison
    private static boolean compareFiles(String path1, String path2) throws IOException {
        byte[] f1 = Files.readAllBytes(Paths.get(path1));
        byte[] f2 = Files.readAllBytes(Paths.get(path2));

        if (f1.length != f2.length)
            return false;

        for (int i = 0; i < f1.length; i++) {
            if (f1[i] != f2[i])
                return false;
        }
        return true;
    }
}
