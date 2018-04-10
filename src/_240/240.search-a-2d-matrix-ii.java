package _240;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;

            if (target > matrix[i][j])
                i++;
            else
                j--;
        }

        return false;
    }


//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0)
//            return false;
//
//        boolean exist = isExist(0, matrix[0].length - 1, target, matrix);
//        System.out.println(exist);
//        return exist;
//    }
//
//    private boolean isExist(int startRow, int startColumn, int target, int[][] matrix) {
//        if (startRow >= matrix.length || startColumn < 0)
//            return false;
//
//        int pivot = matrix[startRow][startColumn];
//
//        if (target == pivot)
//            return true;
//
//        if (target < pivot)
//            return isExist(startRow, startColumn - 1, target, matrix);
//        else
//            return isExist(startRow + 1, startColumn, target, matrix);
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 18));
    }
}