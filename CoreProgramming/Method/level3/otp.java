package Method.level3;

/*
 * Program: OTP Generator and Uniqueness Checker
 * Purpose: Generates 10 random 6-digit OTPs and ensures they are all unique.
 */
public class otp {
    public static void main(String[] args) {
        String[] otps = new String[10];

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs: " + java.util.Arrays.toString(otps));
        System.out.println("Are all OTPs unique? " + checkUnique(otps));
    }

    public static String generateOTP() {
        // Generates a random 6-digit number between 100000 and 999999
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    public static boolean checkUnique(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j]))
                    return false;
            }
        }
        return true;
    }
}
