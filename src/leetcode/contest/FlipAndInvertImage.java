package leetcode.contest;

import java.util.Arrays;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        // flip
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][n - 1 - j];
                A[i][n - 1 - j] = tmp;
            }
        }

        // invert
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0)
                    A[i][j] = 1;
                else
                    A[i][j] = 0;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FlipAndInvertImage().flipAndInvertImage(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 0, 1},
                new int[]{0, 0, 0}
        })));

        System.out.println(Arrays.deepToString(new FlipAndInvertImage().flipAndInvertImage(new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 0}
        })));
    }
}
