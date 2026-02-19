package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

/*
 * 15. Encrypt and Decrypt CSV Data
 * Encrypt the sensitive fields (e.g., Salary, Email) while writing to a CSV file.
 * Decrypt them when reading the file.
 */
public class EncryptDecryptCSV {

    public static void main(String[] args) {
        String originalFile = "csvDataHandling/csv/employees.csv"; // Using existing
        String encryptedFile = "csvDataHandling/csv/employees_encrypted.csv";

        // 1. Read Original, Encrypt Sensitive Data, Write to New File
        encryptAndWrite(originalFile, encryptedFile);

        // 2. Read Encrypted File, Decrypt, and Print
        readAndDecrypt(encryptedFile);
    }

    private static void encryptAndWrite(String inputFile, String outputFile) {
        System.out.println("Encrypting data from " + inputFile + " to " + outputFile);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(outputFile)) {

            String line;
            String header = br.readLine();
            writer.write(header + "\n"); // Write header as is

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    // Assuming columns: ID, Name, Department, Salary
                    // Encrypt Salary (Index 3)
                    String salary = columns[3].trim();
                    String encryptedSalary = Base64.getEncoder().encodeToString(salary.getBytes());

                    writer.write(columns[0] + "," + columns[1] + "," + columns[2] + "," + encryptedSalary + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndDecrypt(String inputFile) {
        System.out.println("\nReading and Decrypting data from " + inputFile + ":");
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            String header = br.readLine();
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    String encryptedSalary = columns[3].trim();
                    String decryptedSalary = new String(Base64.getDecoder().decode(encryptedSalary));

                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] +
                            ", Dept: " + columns[2] + ", Salary: " + decryptedSalary + " (Decrypted)");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
