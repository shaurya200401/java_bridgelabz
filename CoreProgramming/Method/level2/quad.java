package Method.level2;

/*
 * Program: Quadratic Equation Solver
 * Purpose: Calculates the roots of a quadratic equation (ax^2 + bx + c = 0).
 */
public class quad {
    public static double[] findRoots(double a, double b, double c) {
        // Calculate delta
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta > 0) {
            return new double[] { (-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a) };
        } else if (delta == 0) {
            return new double[] { -b / (2 * a) };
        }
        return new double[0];
    }
}
