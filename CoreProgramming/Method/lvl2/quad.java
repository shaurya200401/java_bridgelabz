package Method.lvl2;

public class quad {
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta > 0) {
            return new double[]{(-b + Math.sqrt(delta))/(2*a), (-b - Math.sqrt(delta))/(2*a)};
        } else if (delta == 0) {
            return new double[]{-b / (2 * a)};
        }
        return new double[0];
    }
}