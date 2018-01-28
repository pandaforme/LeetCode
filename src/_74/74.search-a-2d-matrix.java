package _74;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        boolean exist = isExist(0, matrix.length - 1, target, matrix);
        System.out.println(exist);
        return exist;
    }

    private boolean isExist(int startRow, int endRow, int target, int[][] matrix) {
        if (startRow > endRow)
            return false;

        int middleRow = startRow + (endRow - startRow) / 2;
        int lastPivot = matrix[middleRow][matrix[0].length - 1];
        int startPivot = matrix[middleRow][0];

        if (target == lastPivot || target == startPivot)
            return true;

        if (startPivot < target && target < lastPivot)
            return Arrays.binarySearch(matrix[middleRow], target) >= 0;

        if (target < lastPivot)
            return isExist(startRow, middleRow - 1, target, matrix);
        else
            return isExist(middleRow + 1, endRow, target, matrix);
    }

    public static void main(String[] args) {
        new Solution().searchMatrix(new int[][]{
                {1, 3}}, 1);
    }
}