package _73;

import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstRowContainZero = false;
        boolean isColumnContainZero = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowContainZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isColumnContainZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }


        if (isFirstRowContainZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;

            }
        }

        if (isColumnContainZero) {
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = null;

        matrix = new int[][]{
                new int[]{0, 0, 0, 5},
                new int[]{4, 3, 1, 4},
                new int[]{0, 1, 1, 4},
                new int[]{1, 2, 1, 3},
                new int[]{0, 0, 1, 1}
        };

        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5},
        };

        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1},
        };

        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
