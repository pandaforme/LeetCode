package _74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        return helper(matrix, 0, n - 1, m, n, target);

    }

    private boolean helper(int[][] matrix, int i, int j, int m, int n, int target) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;

        if (matrix[i][j] == target)
            return true;
        if (target > matrix[i][j])
            return helper(matrix, i + 1, j, m, n, target);
        else
            return helper(matrix, i, j - 1, m, n, target);
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
