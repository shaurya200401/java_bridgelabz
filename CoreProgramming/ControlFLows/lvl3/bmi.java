package ControlFLows.lvl3;
import java.util.Scanner;

public class bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight (kg) and height (cm): ");
        double weight = sc.nextDouble();
        double heightCm = sc.nextDouble();

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        System.out.printf("BMI: %.1f | Status: %s\n", bmi, status);
    }
}