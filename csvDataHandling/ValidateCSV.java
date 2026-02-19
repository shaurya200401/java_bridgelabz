package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/*
 * 8. Validate CSV Data Before Processing
 * Ensure that the "Email" column follows a valid email format using regex.
 * Ensure that "Phone Numbers" contain exactly 10 digits.
 * Print any invalid rows with an error message.
 */
public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "csvDataHandling/csv/contacts.csv";
        // Simple regex for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Skip header for validation, or validate it too if needed

            int rowNum = 1;
            while ((line = br.readLine()) != null) {
                rowNum++;
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    String email = columns[2].trim();
                    String phone = columns[3].trim();

                    boolean isEmailValid = emailPattern.matcher(email).matches();
                    boolean isPhoneValid = phone.matches("\\d{10}");

                    if (!isEmailValid || !isPhoneValid) {
                        System.out.println("Error at row " + rowNum + ": " + line);
                        if (!isEmailValid)
                            System.out.println("  - Invalid Email: " + email);
                        if (!isPhoneValid)
                            System.out.println("  - Invalid Phone: " + phone);
                    } else {
                        System.out.println("Row " + rowNum + " is valid.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
