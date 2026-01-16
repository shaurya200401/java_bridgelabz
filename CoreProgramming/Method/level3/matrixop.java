package Method.level3;

/*
 * Program: Matrix Operations Library
 * Purpose: Provides methods for matrix addition, multiplication, transpose, and determinant of a 2x2 matrix.
 */
public class matrixop {
    public static double[][] add(double[][] a, double[][] b) {
        int r = a.length, c = a[0].length;
        double[][] res = new double[r][c];
        // Matrix addition logic
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        double[][] res = new double[r1][c2];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    res[i][j] += a[i][k] * b[k][j];
        return res;
    }

    public static double[][] transpose(double[][] m) {
        double[][] res = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                res[j][i] = m[i][j];
        return res;
    }

    public static double det2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }
}
