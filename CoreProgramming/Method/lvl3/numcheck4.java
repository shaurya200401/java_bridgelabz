package Method.lvl3;

public class numcheck4 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    public static boolean isNeon(int n) {
        int square = n * n;
        int sum = numcheck2.sumDigits(numcheck1.getDigitsArray(square));
        return sum == n;
    }

    public static boolean isSpy(int n) {
        int[] digits = numcheck1.getDigitsArray(n);
        int sum = 0, prod = 1;
        for (int d : digits) { sum += d; prod *= d; }
        return sum == prod;
    }

    public static boolean isAutomorphic(int n) {
        int square = n * n;
        return String.valueOf(square).endsWith(String.valueOf(n));
    }

    public static boolean isBuzz(int n) {
        return (n % 7 == 0 || n % 10 == 7);
    }

    public static void main(String[] args) {
        System.out.println("9 is Neon: " + isNeon(9));
        System.out.println("1123 is Spy: " + isSpy(1123));
        System.out.println("25 is Automorphic: " + isAutomorphic(25));
    }
}