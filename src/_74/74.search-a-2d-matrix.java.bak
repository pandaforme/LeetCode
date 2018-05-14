package _74;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;

        return helper(matrix, target, 0, matrix.length - 1);
    }

    private boolean helper(int[][] matrix, int target, int start, int end) {
        if (start > end)
            return false;

        int middle = (start + end) / 2;
        int search = Arrays.binarySearch(matrix[middle], target);
        if (search >= 0)
            return true;
        else {
            if (target > matrix[middle][matrix[0].length - 1])
                return helper(matrix, target, middle + 1, end);
            else
                return helper(matrix, target, start, middle - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        new int[]{},
                }, 1
        ));

        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        new int[]{1},
                }, 1
        ));

        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 50}
                }, 13
        ));

        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 50}
                }, 3
        ));
    }
}