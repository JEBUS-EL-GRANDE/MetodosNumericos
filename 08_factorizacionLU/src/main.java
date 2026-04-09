public class main {
    public static void main(String[] args) {
        double[][] A = {
            {3, -0.1,-0.2},
            {0.1, 7, -0.3},
            {0.3, -0.2, 10,} 
        };
        double[] b = {3, -3, 3};
        double[][][] LU = luDecomposition(A);
        double[] solution = solveLU(LU[0], LU[1], b);
        printSolution(solution);
    }

    // Método para realizar la descomposición LU
    public static double[][][] luDecomposition(double[][] A){
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

    // Método para imprimir la solución
    public static void printSolution(double[] solution) {
        System.out.println("Soluciones:");
        for (int i = 0; i < solution.length; i++) {
            System.out.printf("x%d = %.2f\n", i + 1, solution[i]);
        }
    }
}
