package Method.lvl2;

public class numprop {
    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int n1, int n2) {
        if (n1 > n2)
            return 1;
        return (n1 == n2) ? 0 : -1;
    }

    public static void main(String[] args) {
        // Run tests
        int[] nums = { 10, -5, 22, 13, 10 };
        for (int n : nums) {
            if (isPositive(n)) {
                System.out.print("Positive and " + (isEven(n) ? "Even" : "Odd"));
            } else
                System.out.print("Negative");
            System.out.println();
        }
        System.out.println("Comparison first/last: " + compare(nums[0], nums[4]));
    }
}