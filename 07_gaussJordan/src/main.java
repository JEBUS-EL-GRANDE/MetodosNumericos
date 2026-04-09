public class main {
    public static void main(String[] args) {
        double[][] matrix = {
            {3, -0.1,-0.2,7.85},
            {0.1, 7, -0.3, -19.3},
            {0.3, -0.2, 10, 71.4} 
        };
        gaussJordan(matrix);
        printSolution(matrix);
    }
    public static void gaussJordan(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            double diagElement = matrix[i][i];
            for (int j = 0; j <= n; j++) {
                matrix[i][j] /= diagElement;
            }
            // Hacer cero los elementos de las demás filas en la columna actual
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j <= n; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }
    }
    public static void printSolution(double[][] matrix) {
        int n = matrix.length;
        System.out.println("Soluciones:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.2f\n", i + 1, matrix[i][n]);
        }
    }
}