package interview.easy;

import java.util.Arrays;

public class RotateImage {
    // Using tricky solution is better than a normal solution...
    // Because you need to write a lot of boilerplate codes and handle edge cases
    public void rotate(int[][] matrix) {
        // rotate matrix upside down
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = tmp;
        }

        // swap the symmetry
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];

                // it is really harder to figure out those indices formula
                // using examples to sum up those formula is better to remember it
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        new RotateImage().rotate1(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
