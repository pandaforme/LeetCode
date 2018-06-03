package _54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new ArrayList<>();
        int n = matrix[0].length;


        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.ceil(m / 2d); i++) {

            boolean isAdd = false;
            // right
            for (int j = i; j < n - i; j++) {
                result.add(matrix[i][j]);
                isAdd = true;
            }

            if (!isAdd)
                break;


            isAdd = false;
            // down
            for (int j = i + 1; j < m - i; j++) {
                result.add(matrix[j][n - 1 - i]);
                isAdd = true;
            }

            if (!isAdd)
                break;

            isAdd = false;
            // left
            for (int j = n - i - 2; j >= i; j--) {
                result.add(matrix[m - 1 - i][j]);
                isAdd = true;

            }

            if (!isAdd)
                break;

            isAdd = false;
            // up
            for (int j = m - i - 2; j > i; j--) {
                result.add(matrix[j][i]);
                isAdd = true;
            }

            if (!isAdd)
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1}
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1},
                new int[]{2},
                new int[]{3},
                new int[]{4},
                new int[]{5},
                new int[]{6},
                new int[]{7},
                new int[]{8},
                new int[]{9},
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{7, 8, 9, 10, 11, 12},
                new int[]{13, 14, 15, 16, 17, 18},
                new int[]{19, 20, 21, 22, 23, 24}
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{7, 8, 9, 10, 11, 12},
                new int[]{13, 14, 15, 16, 17, 18},
                new int[]{19, 20, 21, 22, 23, 24},
                new int[]{19, 20, 21, 22, 23, 24}
        }));
    }
}
