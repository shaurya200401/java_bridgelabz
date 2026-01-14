package Method.lvl3;

public class scorecard {
    public static void main(String[] args) {
        int n = 5; // example number of students
        int[][] scores = new int[n][3]; // Physics, Chem, Math

        System.out.println("ID\tPhys\tChem\tMath\tTotal\tAvg\tPerc");
        for (int i = 0; i < n; i++) {
            int total = 0;
            System.out.print((i+1) + "\t");
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + (int)(Math.random() * 90);
                total += scores[i][j];
                System.out.print(scores[i][j] + "\t");
            }
            double avg = total / 3.0;
            System.out.printf("%d\t%.2f\t%.2f%%\n", total, avg, avg);
        }
    }
}