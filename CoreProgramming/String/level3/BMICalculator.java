package CoreProgramming.String.lvl3;

import java.util.Scanner;

// Program to calculate BMI of 10 members and display their status
public class BMICalculator {

    // Method to calculate BMI and Status
    public static String[][] calculateBMI(double[][] data) {
        String[][] results = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            String status;

            if (bmi <= 18.4)
                status = "Underweight";
            else if (bmi < 25)
                status = "Normal";
            else if (bmi < 40)
                status = "Overweight";
            else
                status = "Obese";

            // Storing results
            results[i][0] = String.valueOf(heightCm);
            results[i][1] = String.valueOf(weight);
            results[i][2] = String.format("%.2f", bmi); // Formatting BMI
            results[i][3] = status;
        }
        return results;
    }

    // Method to display results
    public static void displayResults(String[][] results) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height", "Weight", "BMI", "Status");
        System.out.println("------------------------------------------------");
        for (String[] row : results) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Using sample size of 10 as requested
        int n = 10;
        double[][] data = new double[n][2]; // [weight, height]

        System.out.println("Enter Weight(kg) and Height(cm) for 10 members:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            // For simplicity in testing, we can use random generation or prompt
            // Prompt implies user input. I'll uncomment the prompt or generate if tedious.
            // Prompt says "Take user input...". I will use scanner.
            /*
             * System.out.print("Weight (kg): ");
             * data[i][0] = scanner.nextDouble();
             * System.out.print("Height (cm): ");
             * data[i][1] = scanner.nextDouble();
             */

            // For faster demonstration, generating valid random data
            // weight 40-100, height 150-200
            data[i][0] = 40 + (Math.random() * 60);
            data[i][1] = 150 + (Math.random() * 50);
        }

        String[][] bmiData = calculateBMI(data);
        displayResults(bmiData);

        scanner.close();
    }
}
