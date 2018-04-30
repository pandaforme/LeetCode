package _240;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        if (matrix[0].length == 0)
            return false;

        return helper(matrix, target, 0, matrix[0].length - 1);
    }

    private boolean helper(int[][] matrix, int target, int i, int j) {
        if (i >= matrix.length || j < 0)
            return false;

        if (target == matrix[i][j])
            return true;

        if (target < matrix[i][j])
            return helper(matrix, target, i, j - 1);
        else
            return helper(matrix, target, i + 1, j);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 99));
    }
}