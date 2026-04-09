public class main {
    public static void main(String[] args) {
        double[][] A = {
            {2, -1, -2},
            {-3, -1, 2},
            {-2, 1, 2}
        };
        double[][] inverse = calculateInverse(A);

        System.out.println("Matriz Inversa:");
        printMatrix(inverse);
    }
    // Método para realizar la descomposición LU
    public static double[][][] luDecomposition(double[][] A) {
        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    L[j][i] = 0;
                } else {
                    L[j][i] = A[j][i];
                    for (int k = 0; k < i; k++) {
                        L[j][i] -= L[j][k] * U[k][i];
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    U[i][j] = 0;
                } else if (j == i) {
                    U[i][j] = 1;
                } else {
                    U[i][j] = A[i][j] / L[i][i];
                    for (int k = 0; k < i; k++) {
                        U[i][j] -= ((L[i][k] * U[k][j]) / L[i][i]);
                    }
                }
            }
        }

        return new double[][][] { L, U };
    }

    // Método para resolver el sistema LUx = b
    public static double[] solveLU(double[][] L, double[][] U, double[] b) {
        int n = b.length;
        double[] y = new double[n];
        double[] x = new double[n];

        // Resolver Ly = b
        for (int i = 0; i < n; i++) {
            y[i] = b[i];
            for (int j = 0; j < i; j++) {
                y[i] -= L[i][j] * y[j];
            }
            y[i] /= L[i][i];
        }

        // Resolver Ux = y
        for (int i = n - 1; i >= 0; i--) {
            x[i] = y[i];
            for (int j = i + 1; j < n; j++) {
                x[i] -= U[i][j] * x[j];
            }
        }

        return x;
    }
    // Método para calcular la matriz inversa usando la descomposición LU
    public static double[][] calculateInverse(double[][] A) {
        int n = A.length;
        double[][] inverse = new double[n][n];
        double[][][] LU = luDecomposition(A);

        for (int i = 0; i < n; i++) {
            double[] e = new double[n];
            e[i] = 1;
            double[] column = solveLU(LU[0], LU[1], e);
            for (int j = 0; j < n; j++) {
                inverse[j][i] = column[j];
            }
        }

        return inverse;
    }
    // Método para imprimir una matriz
    public static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}