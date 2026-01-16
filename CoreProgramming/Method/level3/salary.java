package Method.level3;

/*
 * Program: Employee Salary Bonus Calculator
 * Purpose: Calculates new salary with bonus for 10 employees based on their years of service.
 */
public class salary {
    public static void main(String[] args) {
        double[][] data = new double[10][5]; // OldSal, Years, Bonus%, BonusAmt, NewSal
        double totalOld = 0, totalNew = 0, totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + Math.random() * 90000; // 5-digit salary
            data[i][1] = Math.random() * 10; // Service years
            // Calculate bonus based on service years
            double rate = (data[i][1] > 5) ? 0.05 : 0.02;
            data[i][2] = rate * 100;
            data[i][3] = data[i][0] * rate;
            data[i][4] = data[i][0] + data[i][3];

            totalOld += data[i][0];
            totalBonus += data[i][3];
            totalNew += data[i][4];
        }

        System.out.println("Old Sal\tYears\tBonus%\tBonus\tNew Sal");
        for (double[] emp : data) {
            System.out.printf("%.2f\t%.1f\t%.0f%%\t%.2f\t%.2f\n", emp[0], emp[1], emp[2], emp[3], emp[4]);
        }
    }
}
