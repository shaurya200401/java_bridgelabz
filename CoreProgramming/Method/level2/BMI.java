package Method.level2;

/*
 * Program: BMI Calculator (Method)
 * Purpose: Calculates BMI and status for 10 persons using methods and arrays.
 */
public class BMI {
    public static void main(String[] args) {
        // Initialize data array
        double[][] data = new double[10][3];
        calculateBMI(data);
        String[] status = getStatus(data);
    }

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightM = data[i][1] / 100.0;
            data[i][2] = data[i][0] / (heightM * heightM);
        }
    }

    public static String[] getStatus(double[][] data) {
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }
}
