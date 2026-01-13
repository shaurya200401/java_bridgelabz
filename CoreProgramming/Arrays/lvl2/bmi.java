package Arrays.lvl2;

import java.util.Scanner;

public class bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int persons = sc.nextInt();
        if (persons <= 0) {
            System.out.println("Error: Number of persons must be positive");
            return;
        }

        double[] weight = new double[persons];
        double[] height = new double[persons];
        double[] bmi = new double[persons];
        String[] status = new String[persons];

        for (int i = 0; i < persons; i++) {
            double w = sc.nextDouble();
            double h = sc.nextDouble();
            if (w <= 0 || h <= 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }
            weight[i] = w;
            height[i] = h;
        }

        for (int i = 0; i < persons; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("BMI Report:");
        for (int i = 0; i < persons; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + height[i] +
                    ", Weight = " + weight[i] +
                    ", BMI = " + bmi[i] +
                    ", Status = " + status[i]);
        }
    }
}