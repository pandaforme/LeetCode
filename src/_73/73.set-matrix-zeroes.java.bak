package _73;

import java.util.Arrays;

class Solution {

    // using O(1) space
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        // whether set the first row to 0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        // whether set the first column to 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        // set 0 to matrix[i][0] and matrix[0][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set related rows to 0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set related columns to 0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isFirstColumnZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    // using O(m + n) space
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        Set<Integer> setI = new HashSet<>();
//        Set<Integer> setJ = new HashSet<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    setI.add(i);
//                    setJ.add(j);
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (setI.contains(i) || setJ.contains(j)) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    // naive solution using O(mn) space
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][] newMatrix = new int[m][n];
//
//        // initial newMatrix
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                newMatrix[i][j] = Integer.MAX_VALUE;
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    // set its entire row and column to 0 in newMatrix
//                    for (int k = 0; k < n; k++)
//                        newMatrix[i][k] = 0;
//                    for (int k = 0; k < m; k++)
//                        newMatrix[k][j] = 0;
//                } else if (matrix[i][j] != 0) {
//                    // set its original value in newMatrix
//                    if (newMatrix[i][j] != 0)
//                        newMatrix[i][j] = matrix[i][j];
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = newMatrix[i][j];
//            }
//        }
//    }

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
