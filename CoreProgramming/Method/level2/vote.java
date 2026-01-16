package Method.level2;

import java.util.Scanner;

/*
 * Program: Student Voting Eligibility
 * Purpose: Checks 10 students' voting eligibility based on age using a method.
 */
public class vote {
    public boolean canStudentVote(int age) {
        if (age < 0)
            return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vote svc = new vote();
        int[] ages = new int[10];

        // Check voting eligibility for 10 students
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.println("Can vote: " + svc.canStudentVote(ages[i]));
        }
        sc.close();
    }
}
