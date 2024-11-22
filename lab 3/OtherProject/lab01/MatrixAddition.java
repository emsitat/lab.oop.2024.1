package hust.soict.dsai.lab01;
import java.util.Scanner;

public class MatrixAddition {
    
	//nhập matrix
    public static int[][] inputMatrix(int r, int c) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[r][c];

        System.out.println("Enter the size of the matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // tổng matrix
    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int r = matrix1.length;
        int c = matrix1[0].length;
        int[][] sumMatrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    // print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix1 = inputMatrix(rows, cols);
        int[][] matrix2 = inputMatrix(rows, cols);

        int[][] sumMatrix = addMatrix(matrix1, matrix2);
        
        System.out.println("Sum of the two matrices:");
        printMatrix(sumMatrix);

        scanner.close();
    }
}
